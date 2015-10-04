package me.exerosis.component.events.system;

import me.exerosis.component.ComponentSystem;
import me.exerosis.component.event.Cancellable;

public class SystemEnableEvent extends SystemEvent implements Cancellable {
    private boolean cancelled;

    public SystemEnableEvent(ComponentSystem system) {
        super(system);
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}