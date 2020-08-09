package ar.net.mgardos.vsfridge.emu;

public interface FridgeDoorController<F, D> {
	/**
	 * Opens the door specified by its id of the Fridge also identified by its id.
	 *
	 * @param fridgeId identifies the Fridge from which the door has to be opened
	 * @param doorId identifies the Door to open
	 */
	void open(F fridgeId, D doorId);

	/**
	 * Closes the door specified by its id of the Fridge also identified by its id.
	 *
	 * @param fridgeId identifies the Fridge from which the door has to be closed
	 * @param doorId identifies the Door to close
	 */
	void close(F fridgeId, D doorId);
}
