package ar.net.mgardos.vsfridge.core.component.base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseFridgeDoorTest {
	private BaseFridgeDoor fridgeDoor;

	@BeforeEach
	void setUp() {
		fridgeDoor = new BaseFridgeDoor();
	}

	@Test
	void testCreateFridgeDoorClosed() {
		assertThat(fridgeDoor.isOpened()).isFalse();
	}

	@Test
	void testOpenFridgeDoorWhenClosed() {
		fridgeDoor.open();

		assertThat(fridgeDoor.isOpened()).isTrue();
	}

	@Test
	void testOpenFridgeDoorWhenAlreadyOpened() {
		fridgeDoor.open();

		assertThatThrownBy(() -> fridgeDoor.open())
				.isInstanceOf(IllegalStateException.class)
				.hasMessage(BaseFridgeDoor.ALREADY_OPENED);
	}

	@Test
	void testCloseFridgeDoorWhenOpened() {
		fridgeDoor.open();
		fridgeDoor.close();

		assertThat(fridgeDoor.isOpened()).isFalse();
	}

	@Test
	void testCloseFridgeDoorWhenAlreadyClosed() {
		fridgeDoor.open();
		fridgeDoor.close();

		assertThatThrownBy(() -> fridgeDoor.close())
				.isInstanceOf(IllegalStateException.class)
				.hasMessage(BaseFridgeDoor.ALREADY_CLOSED);
	}

	@Test
	void testTimeElapsedZeroWhenFridgeDoorCreated() {
		assertThat(fridgeDoor.timeElapsed()).isZero();
	}

	@Test
	void testTimeElapsedAfterFridgeDoorOpened() throws Exception {
		fridgeDoor.open();
		Thread.sleep(1000);

		assertThat(fridgeDoor.timeElapsed()).isGreaterThan(0).isLessThan(2);
	}

	@Test
	void testTimeElapsedIncreasingWhileFridgeDoorOpened() throws Exception {
		fridgeDoor.open();
		Thread.sleep(1000);

		Long timeElapsed1 = fridgeDoor.timeElapsed();
		Thread.sleep(1000);
		Long timeElapsed2 = fridgeDoor.timeElapsed();

		assertThat(timeElapsed1).isGreaterThan(0).isLessThan(2);
		assertThat(timeElapsed2).isGreaterThan(1).isLessThan(3);
		assertThat(timeElapsed2).isGreaterThan(timeElapsed1);
	}

	@Test
	void testTimeElapsedIncreasedAfterFridgeDoorOpenedThenClosed() throws Exception {
		fridgeDoor.open();
		Thread.sleep(1000);
		fridgeDoor.close();

		assertThat(fridgeDoor.timeElapsed()).isGreaterThanOrEqualTo(1).isLessThan(3);
	}

	@Test
	void testZeroTimesOpenedWhenFridgeDoorCreated() {
		assertThat(fridgeDoor.timesOpened()).isZero();
	}

	@Test
	void testOneTimeOpenedAfterFridgeDoorOpened() {
		fridgeDoor.open();

		assertThat(fridgeDoor.timesOpened()).isEqualTo(1);
	}

	@Test
	void testOneTimeOpenedAfterFridgeDoorOpenedAndClosed() {
		fridgeDoor.open();
		fridgeDoor.close();

		assertThat(fridgeDoor.timesOpened()).isEqualTo(1);
	}

	@Test
	void testTwoTimesOpenedAfterFridgeDoorOpenedThenClosedThenOpened() {
		fridgeDoor.open();
		fridgeDoor.close();
		fridgeDoor.open();

		assertThat(fridgeDoor.timesOpened()).isEqualTo(2);
	}
}