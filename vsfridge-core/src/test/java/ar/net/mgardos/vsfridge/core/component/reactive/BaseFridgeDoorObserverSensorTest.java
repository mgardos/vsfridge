package ar.net.mgardos.vsfridge.core.component.reactive;

import ar.net.mgardos.vsfridge.core.component.FridgeDoor;
import ar.net.mgardos.vsfridge.core.component.base.BaseFridgeDoor;
import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static ar.net.mgardos.vsfridge.core.component.reactive.BaseFridgeDoorObserverSensor.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

class BaseFridgeDoorObserverSensorTest {
    private BaseFridgeDoorObserverSensor sensor;

    @Test
    void testSenseWhenInvalidDoorThenException() {
        FridgeDoor door = null;
        sensor = new BaseFridgeDoorObserverSensor();

        assertThatThrownBy(() -> sensor.sense(door)).isInstanceOf(IllegalArgumentException.class)
                                                    .hasMessage(INVALID_SENSOR);
    }

    @Test
    void testSenseWhenAlreadySensingSameDoorThenException() {
        FridgeDoor door = new BaseFridgeDoor();
        sensor = new BaseFridgeDoorObserverSensor();

        sensor.sense(door);

        assertThatThrownBy(() -> sensor.sense(door)).isInstanceOf(IllegalStateException.class)
                                                    .hasMessage(ALREADY_SENSING);
    }

    @Test
    void testSenseWhenAlreadySensingDoorThenException() {
        FridgeDoor sensedDoor = new BaseFridgeDoor();
        FridgeDoor notSensedDoor = new BaseFridgeDoor();
        sensor = new BaseFridgeDoorObserverSensor();

        sensor.sense(sensedDoor);

        assertThatThrownBy(() -> sensor.sense(notSensedDoor)).isInstanceOf(IllegalStateException.class)
                                                    .hasMessage(ALREADY_SENSING);
    }

    @Test
    void testSenseWhenEnableAndDisable() {
        FridgeDoor door = new BaseFridgeDoor();
        sensor = spy(new BaseFridgeDoorObserverSensor(1L, TimeUnit.MILLISECONDS));
        sensor.sense(door);
        sensor.enable();

        Observable.timer(2, TimeUnit.MILLISECONDS)
                  .blockingSubscribe(time -> {
                      sensor.disable();
                  });

        verify(sensor, atLeastOnce()).onSubscribe(any());
        verify(sensor, atLeastOnce()).onNext(any());
        verify(sensor, atLeastOnce()).onComplete();
    }

    @Test
    void testEnableWhenSensorNotSensingDoorThenException() {
        sensor = new BaseFridgeDoorObserverSensor();

        assertThatThrownBy(() -> sensor.enable()).isInstanceOf(IllegalStateException.class)
                                                 .hasMessage(SENSOR_NOT_INITIALIZED);
    }

    @Test
    void testEnableWhenAlreadyEnabledThenException() {
        FridgeDoor door = new BaseFridgeDoor();
        sensor = spy(new BaseFridgeDoorObserverSensor());

        sensor.sense(door);
        sensor.enable();

        assertThatThrownBy(() -> sensor.enable()).isInstanceOf(IllegalStateException.class)
                                                 .hasMessage(ALREADY_ACCEPTING_STATUS);
        verify(sensor, times(1)).onSubscribe(any());
        verify(sensor, never()).onError(any());

        sensor.disable();
    }

    @Test
    void testDisableWhenSensorNotPreviouslyEnabledThenException() {
        sensor = new BaseFridgeDoorObserverSensor();

        assertThatThrownBy(() -> sensor.disable()).isInstanceOf(IllegalStateException.class)
                                                  .hasMessage(SENSOR_NOT_ENABLED);
    }

    @Test
    void testDisableWhenPreviouslyDisabledThenException() {
        FridgeDoor door = new BaseFridgeDoor();
        sensor = spy(new BaseFridgeDoorObserverSensor());

        sensor.sense(door);
        sensor.enable();
        sensor.disable();

        assertThatThrownBy(() -> sensor.disable()).isInstanceOf(IllegalStateException.class)
                                                  .hasMessage(SENSOR_NOT_ENABLED);
        verify(sensor, times(1)).onSubscribe(any());
    }
}