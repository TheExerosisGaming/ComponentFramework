package me.exerosis.component.event;

public interface Cancellable {
    default boolean isCancelled() {
        return CancellableStorage.isCancelled(this);
    }

    default void setCancelled(boolean cancelled) {
        CancellableStorage.setCancelled(this, cancelled);
    }
}