package ar.net.mgardos.vsfridge.core.component.base;

import ar.net.mgardos.vsfridge.core.component.FridgeDoor;

import java.util.Iterator;
import java.util.Optional;

public class BaseFridgeDoorsIterator implements Iterator<FridgeDoor> {
    private Optional<FridgeDoor[]> doors;
    private int index;

    BaseFridgeDoorsIterator(FridgeDoor... doors) {
        this.doors = Optional.ofNullable(doors);
    }

    @Override
    public boolean hasNext() {
        return doors.map(doors -> index <= doors.length-1)
                    .orElse(false);
    }

    @Override
    public FridgeDoor next() {
        return doors.filter(doors -> doors.length > 0)
                    .filter(doors -> doors.length > index)
                    .map(doors -> doors[index++])
                    .orElse(null);
    }
}
