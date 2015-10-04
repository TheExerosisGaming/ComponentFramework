package me.exerosis.component.events.system;

import me.exerosis.component.ComponentSystem;
import me.exerosis.component.event.Cancellable;

public class SystemDisableEvent extends SystemEvent implements Cancellable {
    private boolean cancelled;

    public SystemDisableEvent(ComponentSystem system) {
        super(system);
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
        this.cancelled = cancelled;
    }
}