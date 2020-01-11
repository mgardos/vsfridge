package ar.net.mgardos.vsfridge.core.event;

public interface EventBasedFridge {
    void processEvent(FridgeEvent event);
}
