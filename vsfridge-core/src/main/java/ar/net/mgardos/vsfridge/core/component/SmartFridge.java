package ar.net.mgardos.vsfridge.core.component;

import ar.net.mgardos.vsfridge.core.Product;

public interface SmartFridge {
    default Boolean isPlugged() {
        return false;
    }

    default Boolean isTurnedOn() {
        return false;
    }

    default void plugIn() {
        throw new RuntimeException();
    }

    default void turnOn() {
        throw new RuntimeException();
    }

    default void unplug() {
        throw new RuntimeException();
    }

    default void open() {
        throw new RuntimeException();
    }

    default void put(Product product) {
        throw new RuntimeException();
    }

    default void take(Product product) {
        throw new RuntimeException();
    }

    default void close() {
        throw new RuntimeException();
    }

    default void provision() {
        throw new RuntimeException();
    }

    default void turnOff() {
        throw new RuntimeException();
    }
}
