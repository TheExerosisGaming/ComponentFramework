package me.exerosis.component.events.componet;

import me.exerosis.component.Component;
import me.exerosis.component.ComponentSystem;
import me.exerosis.component.event.Cancellable;
import me.exerosis.component.events.system.SystemEvent;

public class ComponentEvent extends SystemEvent implements Cancellable {
    private final Component component;
    private boolean cancelled;

    public ComponentEvent(ComponentSystem system, Component component) {
        super(system);
        this.component = component;
    }

    public Component getComponent() {
        return component;
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