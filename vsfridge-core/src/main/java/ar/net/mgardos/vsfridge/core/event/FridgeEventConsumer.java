package ar.net.mgardos.vsfridge.core.event;

public interface FridgeEventConsumer {
    void receive(FridgeEvent event);
}
