package ar.net.mgardos.vsfridge.core.component.reactive;

import ar.net.mgardos.vsfridge.core.component.FridgeDoor;
import ar.net.mgardos.vsfridge.core.component.base.BaseFridgeDoor;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

class BaseFridgeDoorObservableSensorTest {
	private BaseFridgeDoorObservableSensor sensor;

	@BeforeEach
	void setUp() {
		sensor = new BaseFridgeDoorObservableSensor();
	}

	@Test
	void getIsOpenedObservable() {
		FridgeDoor door = new BaseFridgeDoor();
		sensor.sense(door);
		sensor.enable();

		Observable.timer(20, TimeUnit.SECONDS, Schedulers.newThread())
		          .subscribe(time -> {
		          	  sensor.disable();
		          });

		/*
		 * By default, when an ObservableSource encounters an error that prevents it from emitting the expected item to
		 * its Observer, the ObservableSource invokes its Observer's onError method, and then quits without invoking any
		 * more of its Observer's methods.
		 */
		Observable.fromIterable(Arrays.asList(FALSE, TRUE, FALSE, FALSE, TRUE, TRUE, FALSE, TRUE, FALSE, TRUE, FALSE))
		          .delay(5, TimeUnit.SECONDS, Schedulers.newThread())
		          .filter(shouldOpen -> shouldOpen.equals(!door.isOpened()))
		          .subscribe(shouldOpen -> {
			          if (shouldOpen) {
			          	  door.open();
			          } else {
			          	  door.close();
			          }
		          });

		sensor.getIsOpenedObservable()
		      .subscribe(isOpened -> System.out.println("Is the door opened? " + isOpened));
	}
}