package ar.net.mgardos.vsfridge.core.component.base;

import ar.net.mgardos.vsfridge.core.component.FridgeDoor;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Spliterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseFridgeDoorsTest {
	private BaseFridgeDoors fridgeDoors;

	@Test
	void testCreateFridgeDoors() {
		fridgeDoors = new BaseFridgeDoors();

		assertThat(fridgeDoors.capacity()).isEqualTo(1);
		assertThat(fridgeDoors.size()).isZero();
		assertThat(fridgeDoors.hasDoors()).isFalse();
	}

	@Test
	void testFridgeDoorsNotCreatedWhenZeroOrLessNumberOfDoors() {
		SoftAssertions assertions = new SoftAssertions();
		assertions.assertThatThrownBy(() -> new BaseFridgeDoors(0, 0, 0))
		          .isInstanceOf(IllegalArgumentException.class)
		          .hasMessage(BaseFridgeDoors.INVALID_DOORS_QUANTITY);
		assertions.assertThatThrownBy(() -> new BaseFridgeDoors(-1, 1, 1))
		          .isInstanceOf(IllegalArgumentException.class)
		          .hasMessage(BaseFridgeDoors.INVALID_DOORS_QUANTITY);
		assertions.assertThatThrownBy(() -> new BaseFridgeDoors(0, -1, 0))
		          .isInstanceOf(IllegalArgumentException.class)
		          .hasMessage(BaseFridgeDoors.INVALID_DOORS_QUANTITY);
		assertions.assertThatThrownBy(() -> new BaseFridgeDoors(3, 2, -1))
		          .isInstanceOf(IllegalArgumentException.class)
		          .hasMessage(BaseFridgeDoors.INVALID_DOORS_QUANTITY);
		assertions.assertThatThrownBy(() -> new BaseFridgeDoors(-1, -1, 1))
		          .isInstanceOf(IllegalArgumentException.class)
		          .hasMessage(BaseFridgeDoors.INVALID_DOORS_QUANTITY);

		assertions.assertAll();
	}

	@Test
	void testFridgeDoorsNotCreatedWhenNullNumberOfDoors() {
		SoftAssertions assertions = new SoftAssertions();
		assertions.assertThatThrownBy(() -> new BaseFridgeDoors(null, null, null))
		          .isInstanceOf(NullPointerException.class)
		          .hasMessage(BaseFridgeDoors.INVALID_DOORS_QUANTITY);
		assertions.assertThatThrownBy(() -> new BaseFridgeDoors(null, 1, 2))
		          .isInstanceOf(NullPointerException.class)
		          .hasMessage(BaseFridgeDoors.INVALID_DOORS_QUANTITY);
		assertions.assertThatThrownBy(() -> new BaseFridgeDoors(2, null, null))
		          .isInstanceOf(NullPointerException.class)
		          .hasMessage(BaseFridgeDoors.INVALID_DOORS_QUANTITY);
		assertions.assertThatThrownBy(() -> new BaseFridgeDoors(1, 3, null))
		          .isInstanceOf(NullPointerException.class)
		          .hasMessage(BaseFridgeDoors.INVALID_DOORS_QUANTITY);

		assertions.assertAll();
	}

	@Test
	void testCreateFridgeDoorsWithCapacityForOneCenterDoor() {
		fridgeDoors = new BaseFridgeDoors(0, 1, 0);

		assertThat(fridgeDoors.capacity()).isEqualTo(1);
		assertThat(fridgeDoors.size()).isZero();
		assertThat(fridgeDoors.hasDoors()).isFalse();
	}

	@Test
	void testCreateFridgeDoorsWithCapacityForOneLeftDoor() {
		fridgeDoors = new BaseFridgeDoors(1, 0, 0);

		assertThat(fridgeDoors.capacity()).isEqualTo(1);
		assertThat(fridgeDoors.size()).isZero();
		assertThat(fridgeDoors.hasDoors()).isFalse();
	}

	@Test
	void testCreateFridgeDoorsWithCapacityForOneRightDoor() {
		fridgeDoors = new BaseFridgeDoors(0, 0, 1);

		assertThat(fridgeDoors.capacity()).isEqualTo(1);
		assertThat(fridgeDoors.size()).isZero();
		assertThat(fridgeDoors.hasDoors()).isFalse();
	}

	@Test
	void testAddOneCenterDoor() {
		fridgeDoors = new BaseFridgeDoors(0, 1, 0);

		fridgeDoors.addDoor(new BaseFridgeDoor());

		assertThat(fridgeDoors.capacity()).isEqualTo(1);
		assertThat(fridgeDoors.size()).isEqualTo(1);
		assertThat(fridgeDoors.hasDoors()).isTrue();
	}

	@Test
	void testAddDoorWhenCapacityReached() {
		fridgeDoors = new BaseFridgeDoors(0, 0, 1);

		fridgeDoors.addDoor(new BaseFridgeDoor());

		assertThatThrownBy(() -> fridgeDoors.addDoor(new BaseFridgeDoor()))
				.isInstanceOf(RuntimeException.class)
				.hasMessage(BaseFridgeDoors.CAPACITY_REACHED);
	}

	@Test
	void testAddDoorWithInvalidDoor() {
		fridgeDoors = new BaseFridgeDoors(1, 1, 1);

		assertThatThrownBy(() -> fridgeDoors.addDoor(null))
				.isInstanceOf(NullPointerException.class)
				.hasMessage(BaseFridgeDoors.UNABLE_TO_ADD_DOOR);
	}

	@Test
	void testIteratorWhenCapacityForLeftDoorsButNoDoors() {
		fridgeDoors = new BaseFridgeDoors(1, 0, 0);

		Iterator<FridgeDoor> it = fridgeDoors.iterator();

		SoftAssertions assertions = new SoftAssertions();
		assertions.assertThat(it).isNotNull();
		assertions.assertThat(it.hasNext()).isFalse();
		assertions.assertThat(it.next()).isNull();

		assertions.assertAll();
	}

	@Test
	void testIteratorWhenCapacityButNoDoors() {
		fridgeDoors = new BaseFridgeDoors(3, 2, 4);

		Iterator<FridgeDoor> it = fridgeDoors.iterator();

		SoftAssertions assertions = new SoftAssertions();
		assertions.assertThat(it).isNotNull();
		assertions.assertThat(it.hasNext()).isFalse();
		assertions.assertThat(it.next()).isNull();

		assertions.assertAll();
	}

	@Test
	void testIteratorWhenCenterAndRightDoors() {
		fridgeDoors = new BaseFridgeDoors(0, 2, 4);
		fridgeDoors.addDoor(new BaseFridgeDoor());
		fridgeDoors.addDoor(new BaseFridgeDoor());
		fridgeDoors.addDoor(new BaseFridgeDoor());

		Iterator<FridgeDoor> it = fridgeDoors.iterator();

		SoftAssertions assertions = new SoftAssertions();
		assertions.assertThat(it).isNotNull();

		int index = 0;
		while (it.hasNext()) {
			index++;
			assertions.assertThat(it.next()).isNotNull();
		}
		assertions.assertThat(index).isEqualTo(3);
		assertions.assertThat(it.hasNext()).isFalse();
		assertions.assertThat(it.next()).isNull();

		assertions.assertAll();
	}

	@Test
	void testIteratorNotSameAsOtherIterator() {
		fridgeDoors = new BaseFridgeDoors(1, 0, 0);

		Iterator<FridgeDoor> it1 = fridgeDoors.iterator();
		Iterator<FridgeDoor> it2 = fridgeDoors.iterator();

		assertThat(it1).isNotSameAs(it2);
	}

	@Test
	void testSpliteratorWhenCapacityForLeftDoorsButNoDoors() {
		fridgeDoors = new BaseFridgeDoors(1, 0, 0);

		Spliterator<FridgeDoor> it = fridgeDoors.spliterator();

		SoftAssertions assertions = new SoftAssertions();
		assertions.assertThat(it).isNotNull();
		assertions.assertThat(it.estimateSize()).isZero();
		assertions.assertAll();
	}

	@Test
	void testSpliteratorWhenCapacityButNoDoors() {
		fridgeDoors = new BaseFridgeDoors(3, 2, 4);

		Spliterator<FridgeDoor> it = fridgeDoors.spliterator();

		SoftAssertions assertions = new SoftAssertions();
		assertions.assertThat(it).isNotNull();
		assertions.assertThat(it.estimateSize()).isZero();
		assertions.assertAll();
	}

	@Test
	void testSpliteratorWhenCenterAndRightDoors() {
		fridgeDoors = new BaseFridgeDoors(0, 2, 4);
		fridgeDoors.addDoor(new BaseFridgeDoor());
		fridgeDoors.addDoor(new BaseFridgeDoor());
		fridgeDoors.addDoor(new BaseFridgeDoor());

		Spliterator<FridgeDoor> it = fridgeDoors.spliterator();

		SoftAssertions assertions = new SoftAssertions();
		assertions.assertThat(it).isNotNull();
		assertions.assertThat(it.estimateSize()).isEqualTo(fridgeDoors.size().longValue());

		it.tryAdvance(door -> {});

		assertions.assertThat(it.estimateSize()).isEqualTo(fridgeDoors.size().longValue() - 1L);
		assertions.assertAll();
	}

	@Test
	void testSpliteratorNotSameAsOtherIterator() {
		fridgeDoors = new BaseFridgeDoors(1, 0, 0);

		Spliterator<FridgeDoor> it1 = fridgeDoors.spliterator();
		Spliterator<FridgeDoor> it2 = fridgeDoors.spliterator();

		assertThat(it1).isNotSameAs(it2);
	}
}