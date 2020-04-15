package ar.net.mgardos.vsfridge.core.component;

import ar.net.mgardos.vsfridge.core.Product;

public interface SmartFridge {
    default Boolean isPlugged() {
        return false;
    }

    default Boolean isTurnedOn() {
        return false;
    }

    /**
     * Informs if any of the fridge doors is opened.
     *
     * @return true if any door is opened, false otherwise.
     */
    default Boolean isOpened() {
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

    /**
     * Opens the door identified by an id. This id could be anything, like a name or code, a number or the very same
     * door object. It is up to the implementation how to handle this functionality.
     *
     * @param id the unique value that identifies the door.
     * @param <T> the type of the door identifier.
     */
    default <T> void open(T id) {
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
