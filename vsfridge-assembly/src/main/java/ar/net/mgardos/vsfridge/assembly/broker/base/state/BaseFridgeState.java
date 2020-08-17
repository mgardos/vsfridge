package ar.net.mgardos.vsfridge.assembly.broker.base.state;

import ar.net.mgardos.vsfridge.assembly.broker.state.FridgeState;
import lombok.AccessLevel;
import lombok.Setter;

public class BaseFridgeState implements FridgeState {
	@Setter(AccessLevel.PACKAGE)
	private Boolean isOpened;

	@Setter(AccessLevel.PACKAGE)
	private Boolean isPlugged;

	@Override
	public Boolean isOpened() {
		return isOpened;
	}

	@Override
	public Boolean isPlugged() {
		return isPlugged;
	}
}
