package ar.net.mgardos.vsfridge.core.component.base;

import ar.net.mgardos.vsfridge.core.component.FridgeDoor;

import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Consumer;

public class BaseFridgeDoorsSpliterator implements Spliterator<FridgeDoor> {
    private Optional<FridgeDoor[]> doors;
    private int current;
    private int last;

    public BaseFridgeDoorsSpliterator(FridgeDoor... doors) {
        this.doors = Optional.ofNullable(doors);
        last = this.doors.map(d -> d.length)
                   .orElse(0);
    }

    private BaseFridgeDoorsSpliterator(int start, int end, FridgeDoor... doors) {
        current = start;
        last = end;
        this.doors = Optional.ofNullable(doors);
    }

    @Override
    public boolean tryAdvance(Consumer<? super FridgeDoor> consumer) {
        int i = current;
        Optional.ofNullable(consumer).ifPresent(c -> {
            doors.filter(d -> estimateSize() > 0)
                 .ifPresent(d -> c.accept(d[current++]));
        });

        return (i++ < current);
    }

    @Override
    public Spliterator<FridgeDoor> trySplit() {
        Double splitSize = estimateSize()/2.0d;

        return Optional.of(splitSize)
                       .filter(size -> size >= 1.0d)
                       .map(size -> size + (Math.ceil(size) - Math.floor(size)))
                       .map(size -> {
                           last -= size.intValue();
                           return new BaseFridgeDoorsSpliterator(last, last + size.intValue(), doors.get());
                       })
                       .orElse(null);
    }

    @Override
    public long estimateSize() {
        return last - current;
    }

    @Override
    public int characteristics() {
        return SIZED | IMMUTABLE | SUBSIZED;
    }
}
