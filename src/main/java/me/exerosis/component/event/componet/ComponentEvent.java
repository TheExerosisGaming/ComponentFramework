package me.exerosis.component.event.componet;

import me.exerosis.component.Component;
import me.exerosis.component.ComponentSystem;
import me.exerosis.component.event.system.SystemEvent;
import me.exerosis.reflection.event.Cancellable;

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