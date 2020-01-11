package ar.net.mgardos.vsfridge.core.ensemble;

import ar.net.mgardos.vsfridge.core.component.SmartFridge;
import ar.net.mgardos.vsfridge.core.component.FridgeDoor;
import ar.net.mgardos.vsfridge.core.component.FridgeShelf;
import ar.net.mgardos.vsfridge.core.component.Sensor;

public interface SmartFridgeBuilder {
    SmartFridge build();
    SmartFridgeBuilder addDoor(FridgeDoor fridgeDoor);
    SmartFridgeBuilder addShelf(FridgeShelf fridgeShelf);
    SmartFridgeBuilder addSensor(Sensor sensor);
}
