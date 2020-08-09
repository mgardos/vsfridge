package ar.net.mgardos.vsfridge.core.ensemble;

import ar.net.mgardos.vsfridge.core.component.SmartFridge;
import ar.net.mgardos.vsfridge.core.component.FridgeDoor;
import ar.net.mgardos.vsfridge.core.component.FridgeShelf;
import ar.net.mgardos.vsfridge.core.component.Sensor;

public interface FridgeBuilder {
    SmartFridge build();
    FridgeBuilder addDoor(FridgeDoor fridgeDoor);
    FridgeBuilder addShelf(FridgeShelf fridgeShelf);
    FridgeBuilder addSensor(Sensor sensor);
}
