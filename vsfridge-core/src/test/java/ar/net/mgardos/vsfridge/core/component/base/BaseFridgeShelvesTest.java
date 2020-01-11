package ar.net.mgardos.vsfridge.core.component.base;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseFridgeShelvesTest {
	private BaseFridgeShelves shelves;

	@Test
	void testCreateFridgeShelvesWithDefaultShelves() {
		shelves = new BaseFridgeShelves();

		assertThat(shelves.hasShelves()).isFalse();
		assertThat(shelves.size()).isEqualTo(0);
		assertThat(shelves.capacity()).isEqualTo(2);
	}

	@Test
	void testCreateFridgeShelvesWithNoShelves() {
		shelves = new BaseFridgeShelves(0);

		assertThat(shelves.hasShelves()).isFalse();
		assertThat(shelves.size()).isEqualTo(0);
		assertThat(shelves.capacity()).isEqualTo(0);
	}

	@Test
	void testCreateFridgeShelvesWithInvalidQuantity() {
		SoftAssertions assertions = new SoftAssertions();
		assertions.assertThatThrownBy(() -> new BaseFridgeShelves(null))
		          .isInstanceOf(NullPointerException.class)
		          .hasMessage(BaseFridgeShelves.INVALID_SHELVES_QUANTITY);
		assertions.assertThatThrownBy(() -> new BaseFridgeShelves(-1))
		          .isInstanceOf(IllegalArgumentException.class)
		          .hasMessage(BaseFridgeShelves.INVALID_SHELVES_QUANTITY);

		assertions.assertAll();
	}

	@Test
	void testAddShelfWithInvalidShelf() {
		shelves = new BaseFridgeShelves(2);

		assertThatThrownBy(() -> shelves.addShelf(null)).isInstanceOf(NullPointerException.class)
		                                                .hasMessage(BaseFridgeShelves.UNABLE_TO_ADD_SHELF);
	}

	@Test
	void testAddShelfWhenNoCapacity() {
		shelves = new BaseFridgeShelves(0);

		assertThatThrownBy(() -> shelves.addShelf(new BaseFridgeShelf())).isInstanceOf(RuntimeException.class)
		                                                                 .hasMessage(BaseFridgeShelves.CAPACITY_REACHED);
	}

	@Test
	void testAddOneShelf() {
		shelves = new BaseFridgeShelves(3);

		shelves.addShelf(new BaseFridgeShelf());

		assertThat(shelves.hasShelves()).isTrue();
		assertThat(shelves.capacity()).isEqualTo(3);
		assertThat(shelves.size()).isEqualTo(1);
	}

	@Test
	void testAddSeveralShelvesToReachCapacity() {
		shelves = new BaseFridgeShelves(2);

		shelves.addShelf(new BaseFridgeShelf());
		shelves.addShelf(new BaseFridgeShelf());

		assertThat(shelves.hasShelves()).isTrue();
		assertThat(shelves.size()).isEqualTo(shelves.capacity());
		assertThat(shelves.hasCapacity()).isFalse();
	}

	@Test
	void testAddMoreShelvesThanCapacity() {
		shelves = new BaseFridgeShelves(1);

		shelves.addShelf(new BaseFridgeShelf());

		assertThatThrownBy(() -> shelves.addShelf(new BaseFridgeShelf())).isInstanceOf(RuntimeException.class)
		                                                                 .hasMessage(BaseFridgeShelves.CAPACITY_REACHED);
	}
}