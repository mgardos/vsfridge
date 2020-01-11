package ar.net.mgardos.vsfridge.core.ensemble;

import ar.net.mgardos.vsfridge.core.component.FridgeDoor;
import ar.net.mgardos.vsfridge.core.component.FridgeShelf;
import ar.net.mgardos.vsfridge.core.component.Sensor;

public interface SmartFridgeFactory {
    FridgeDoor createDoor();
    FridgeShelf createShelf();
    Sensor createWeightSensor();
    Sensor createShapeSensor();
    Sensor createDoorSensor();
    Sensor createInputSensor();
}
