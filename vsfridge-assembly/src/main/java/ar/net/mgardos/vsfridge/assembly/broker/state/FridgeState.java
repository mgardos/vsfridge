package ar.net.mgardos.vsfridge.assembly.broker.state;

public interface FridgeState {
	default Boolean isOpened() {
		return false;
	}

	default Boolean isPlugged() {
		return false;
	}
}
