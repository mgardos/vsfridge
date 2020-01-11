package ar.net.mgardos.vsfridge.core.event;

public class FridgeEvent {
    private FridgeEventSource source;

    public FridgeEvent(FridgeEventSource source) {
        this.source = source;
    }
}
