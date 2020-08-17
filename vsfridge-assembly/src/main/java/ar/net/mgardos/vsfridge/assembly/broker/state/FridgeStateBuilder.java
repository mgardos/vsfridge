package ar.net.mgardos.vsfridge.assembly.broker.state;

public interface FridgeStateBuilder {
	FridgeStateBuilder recordOpen();
	FridgeStateBuilder recordClose();
	FridgeStateBuilder recordIsPlugged();
	FridgeStateBuilder recordUnplugged();
	FridgeState build();
}
