package ar.net.mgardos.vsfridge.core.component.base;

import ar.net.mgardos.vsfridge.core.component.FridgeDoor;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Spliterator;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

class BaseFridgeDoorsSpliteratorTest {
    private BaseFridgeDoorsSpliterator it;

    @Test
    public void testEstimateSizeZeroWhenInvalidDoors() {
        FridgeDoor[] doors = null;
        it = new BaseFridgeDoorsSpliterator(doors);

        assertThat(it.estimateSize()).isZero();
    }

    @Test
    void testEstimateSizeZeroWhenNoDoors() {
        it = new BaseFridgeDoorsSpliterator(new FridgeDoor[0]);

        assertThat(it.estimateSize()).isZero();
    }

    @Test
    void testEstimateSizeOneWhenOneDoors() {
        FridgeDoor[] doors = new FridgeDoor[1];
        doors[0] = new BaseFridgeDoor();
        it = new BaseFridgeDoorsSpliterator(doors);

        assertThat(it.estimateSize()).isEqualTo(1);
    }

    @Test
    public void testTryAdvanceWhenInvalidDoorsAndConsumer() {
        FridgeDoor[] doors = null;
        it = new BaseFridgeDoorsSpliterator(doors);

        assertThat(it.tryAdvance(null)).isFalse();
    }

    @Test
    public void testTryAdvanceWhenInvalidDoors() {
        FridgeDoor[] doors = null;
        it = new BaseFridgeDoorsSpliterator(doors);

        assertThat(it.tryAdvance(d -> {})).isFalse();
    }

    @Test
    public void testTryAdvance() {
        BaseFridgeDoor door = new BaseFridgeDoor();
        FridgeDoor[] doors = {door};
        it = new BaseFridgeDoorsSpliterator(doors);

        Consumer<FridgeDoor> consumer = mock(Consumer.class);
        it.tryAdvance(consumer);

        ArgumentCaptor<BaseFridgeDoor> arg = ArgumentCaptor.forClass(BaseFridgeDoor.class);
        verify(consumer).accept(arg.capture());
        assertThat(arg.getValue()).isSameAs(door);
    }

    @Test
    public void testTryAdvanceWhenNoDoorsLeftToTraverse() {
        BaseFridgeDoor door1 = new BaseFridgeDoor();
        BaseFridgeDoor door2 = new BaseFridgeDoor();
        BaseFridgeDoor door3 = new BaseFridgeDoor();
        FridgeDoor[] doors = {door1, door2, door3};
        it = new BaseFridgeDoorsSpliterator(doors);

        assertThat(it.estimateSize()).isEqualTo(doors.length);
        int i = 0;
        while (i < doors.length) {
            assertThat(it.tryAdvance(d -> {})).isTrue();
            i++;
        }
        assertThat(it.tryAdvance(d -> {})).isFalse();
    }

    @Test
    void testTrySplitWhenInvalidDoors() {
        FridgeDoor[] doors = null;
        it = new BaseFridgeDoorsSpliterator(doors);

        assertThat(it.trySplit()).isNull();
    }

    @Test
    void testTrySplitWhenNotAdvancedAndOneDoor() {
        BaseFridgeDoor door = new BaseFridgeDoor();
        FridgeDoor[] doors = {door};
        it = new BaseFridgeDoorsSpliterator(doors);

        assertThat(it.trySplit()).isNull();
    }

    @Test
    void testTrySplitWhenNotAdvancedAndTwoDoors() {
        BaseFridgeDoor door1 = new BaseFridgeDoor();
        BaseFridgeDoor door2 = new BaseFridgeDoor();
        FridgeDoor[] doors = {door1, door2};
        it = new BaseFridgeDoorsSpliterator(doors);

        assertThat(it.estimateSize()).isEqualTo(doors.length);
        Spliterator<FridgeDoor> spliterator = it.trySplit();

        assertThat(spliterator).isNotNull();
        assertThat(it.estimateSize()).isEqualTo(1);
        assertThat(spliterator.estimateSize()).isEqualTo(1);
    }

    @Test
    void testTrySplitWhenNotAdvancedAndThreeDoors() {
        BaseFridgeDoor door1 = new BaseFridgeDoor();
        BaseFridgeDoor door2 = new BaseFridgeDoor();
        BaseFridgeDoor door3 = new BaseFridgeDoor();
        FridgeDoor[] doors = {door1, door2, door3};
        it = new BaseFridgeDoorsSpliterator(doors);

        assertThat(it.estimateSize()).isEqualTo(doors.length);
        Spliterator<FridgeDoor> spliterator = it.trySplit();

        assertThat(spliterator).isNotNull();
        assertThat(it.estimateSize()).isEqualTo(1);
        assertThat(spliterator.estimateSize()).isEqualTo(2);
    }

    @Test
    void testTrySplitAfterTryAdvanceWhenFourDoors() {
        BaseFridgeDoor door1 = new BaseFridgeDoor();
        BaseFridgeDoor door2 = new BaseFridgeDoor();
        BaseFridgeDoor door3 = new BaseFridgeDoor();
        BaseFridgeDoor door4 = new BaseFridgeDoor();
        FridgeDoor[] doors = {door1, door2, door3, door4};
        it = new BaseFridgeDoorsSpliterator(doors);
        it.tryAdvance(d -> {});

        assertThat(it.estimateSize()).isEqualTo(doors.length-1);
        Spliterator<FridgeDoor> spliterator = it.trySplit();

        assertThat(spliterator).isNotNull();
        assertThat(it.estimateSize()).isEqualTo(1);
        assertThat(spliterator.estimateSize()).isEqualTo(2);
    }

    @Test
    void testTrySplitAfterTryAdvanceWhenFiveDoors() {
        BaseFridgeDoor door1 = new BaseFridgeDoor();
        BaseFridgeDoor door2 = new BaseFridgeDoor();
        BaseFridgeDoor door3 = new BaseFridgeDoor();
        BaseFridgeDoor door4 = new BaseFridgeDoor();
        BaseFridgeDoor door5 = new BaseFridgeDoor();
        FridgeDoor[] doors = {door1, door2, door3, door4, door5};
        it = new BaseFridgeDoorsSpliterator(doors);
        it.tryAdvance(d -> {});

        assertThat(it.estimateSize()).isEqualTo(doors.length-1);
        Spliterator<FridgeDoor> spliterator = it.trySplit();

        assertThat(spliterator).isNotNull();
        assertThat(it.estimateSize()).isEqualTo(2);
        assertThat(spliterator.estimateSize()).isEqualTo(2);
    }

    @Test
    void characteristics() {
    }
}