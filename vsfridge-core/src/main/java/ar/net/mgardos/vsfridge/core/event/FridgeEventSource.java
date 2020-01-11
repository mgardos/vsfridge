package ar.net.mgardos.vsfridge.core.event;

public interface FridgeEventSource {
    void announceEventsTo(FridgeEventConsumer consumer);
}
