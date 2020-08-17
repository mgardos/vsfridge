package ar.net.mgardos.vsfridge.assembly.broker.base.state;

import ar.net.mgardos.vsfridge.assembly.broker.state.FridgeState;
import ar.net.mgardos.vsfridge.assembly.broker.state.FridgeStateBuilder;

public class BaseFridgeStateBuilder implements FridgeStateBuilder {
	private Boolean isOpened;
	private Boolean isPlugged;

	@Override
	public FridgeStateBuilder recordOpen() {
		isOpened = true;
		return this;
	}

	@Override
	public FridgeStateBuilder recordClose() {
		isOpened = false;
		return this;
	}

	@Override
	public FridgeStateBuilder recordIsPlugged() {
		isPlugged = true;
		return this;
	}

	@Override
	public FridgeStateBuilder recordUnplugged() {
		isPlugged = false;
		return this;
	}

	@Override
	public FridgeState build() {
		BaseFridgeState state =  new BaseFridgeState();
		state.setIsOpened(isOpened);
		state.setIsPlugged(isPlugged);

		return state;
	}
}
