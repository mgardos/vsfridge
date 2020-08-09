package ar.net.mgardos.vsfridge.core.component;

import ar.net.mgardos.vsfridge.core.Product;

public interface SmartFridge {
    String ERROR_MSG_TEMPLATE = "The fridge is not capable of %s.";

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
        throw new RuntimeException(String.format(ERROR_MSG_TEMPLATE, "plugging in."));
    }

    default void turnOn() {
        throw new RuntimeException(String.format(ERROR_MSG_TEMPLATE, "turning on."));
    }

    default void unplug() {
        throw new RuntimeException(String.format(ERROR_MSG_TEMPLATE, "unplugging."));
    }

    /**
     * Opens the door identified by an id. This id could be anything, like a name or code, a number or the very same
     * door object. It is up to the implementation how to handle this functionality.
     *
     * @param id the unique value that identifies the door.
     * @param <T> the type of the door identifier.
     */
    default <T> void open(T id) {
        throw new RuntimeException(String.format(ERROR_MSG_TEMPLATE, "opening any door."));
    }

    /**
     * Puts a product inside the fridge.
     *
     * @param product put inside the fridge.
     */
    default void put(Product product) {
        throw new RuntimeException(String.format(ERROR_MSG_TEMPLATE, "putting products inside."));
    }

    /**
     * Takes a product from inside the fridge.
     *
     * @param product took from the fridge.
     */
    default void take(Product product) {
        throw new RuntimeException(String.format(ERROR_MSG_TEMPLATE, "taking products from inside."));
    }

    /**
     * Opens the door identified by an id. This id could be anything, like a name or code, a number or the very same
     * door object. It is up to the implementation how to handle this functionality.
     *
     * @param id the unique value that identifies the door.
     * @param <T> the type of the door identifier.
     */
    default <T> void close(T id) {
        throw new RuntimeException(String.format(ERROR_MSG_TEMPLATE, "closing any door."));
    }

    default void provision() {
        throw new RuntimeException(String.format(ERROR_MSG_TEMPLATE, "provisioning any food."));
    }

    /**
     * Turns the fridge off.
     */
    default void turnOff() {
        throw new RuntimeException(String.format(ERROR_MSG_TEMPLATE, "turning off."));
    }
}
