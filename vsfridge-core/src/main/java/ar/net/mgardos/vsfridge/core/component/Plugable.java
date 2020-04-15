package ar.net.mgardos.vsfridge.core.component;

public interface Plugable<T> {
    /**
     * Establish a link between two object or component, the one that implements this interface and the one that is
     * passed as argument. The one that plugs in may query or notify the one that it plugs to.
     *
     * @param plugTo The object or component that is queried or notified by the one implementing this interface.
     */
    default void plugIn(T plugTo) {}
}
