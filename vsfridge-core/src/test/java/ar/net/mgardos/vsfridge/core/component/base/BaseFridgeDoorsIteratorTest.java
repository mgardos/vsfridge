package ar.net.mgardos.vsfridge.core.component.base;

import ar.net.mgardos.vsfridge.core.component.FridgeDoor;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseFridgeDoorsIteratorTest {
    private BaseFridgeDoorsIterator it;

    @Test
    void testHasNextWhenInvalidDoors() {
        FridgeDoor[] doors = null;
        it = new BaseFridgeDoorsIterator(doors);

        assertThat(it.hasNext()).isFalse();
    }

    @Test
    void testHasNextWhenNoDoors() {
        it = new BaseFridgeDoorsIterator(new FridgeDoor[0]);

        assertThat(it.hasNext()).isFalse();
    }

    @Test
    void testHasNextWhenOneDoor() {
        FridgeDoor[] doors = new FridgeDoor[1];
        doors[0] = new BaseFridgeDoor();
        it = new BaseFridgeDoorsIterator(doors);

        Boolean hasDoorsBeforeNext = it.hasNext();
        it.next();
        Boolean hasDoorsAfterNext = it.hasNext();

        assertThat(hasDoorsBeforeNext).isTrue();
        assertThat(hasDoorsAfterNext).isFalse();
    }

    @Test
    void testHasNextWhenManyDoors() {
        FridgeDoor[] doors = new FridgeDoor[5];
        doors[0] = new BaseFridgeDoor();
        doors[1] = new BaseFridgeDoor();
        doors[2] = new BaseFridgeDoor();
        doors[3] = new BaseFridgeDoor();
        doors[4] = new BaseFridgeDoor();
        it = new BaseFridgeDoorsIterator(doors);

        int count = 0;
        FridgeDoor currentDoor = new BaseFridgeDoor();
        FridgeDoor nextDoor;
        SoftAssertions assertions = new SoftAssertions();
        while (it.hasNext()) {
            count++;
            nextDoor = it.next();

            assertions.assertThat(nextDoor).isNotNull();
            assertions.assertThat(nextDoor).isNotSameAs(currentDoor);

            currentDoor = nextDoor;
        }

        assertThat(count).isEqualTo(5);
    }

    @Test
    void testNextMultipleCallsWhenInvalidDoors() {
        FridgeDoor[] doors = null;
        it = new BaseFridgeDoorsIterator(doors);

        assertThat(it.next()).isNull();
        assertThat(it.next()).isNull();
    }

    @Test
    void testNextMultipleCallsWhenNoDoors() {
        it = new BaseFridgeDoorsIterator(new FridgeDoor[0]);

        assertThat(it.next()).isNull();
        assertThat(it.next()).isNull();
    }

    @Test
    void testNextMultipleCallsWhenManyDoors() {
        FridgeDoor[] doors = new FridgeDoor[3];
        doors[0] = new BaseFridgeDoor();
        doors[1] = new BaseFridgeDoor();
        doors[2] = new BaseFridgeDoor();

        it = new BaseFridgeDoorsIterator(doors);

        assertThat(it.next()).isNotNull();
        assertThat(it.next()).isNotNull();
        assertThat(it.next()).isNotNull();
        assertThat(it.next()).isNull();
        assertThat(it.next()).isNull();
    }
}