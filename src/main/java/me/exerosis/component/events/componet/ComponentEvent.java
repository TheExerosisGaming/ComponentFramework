package me.exerosis.component.events.componet;

import me.exerosis.component.Component;
import me.exerosis.component.ComponentSystem;
import me.exerosis.component.events.system.SystemEvent;
import me.exerosis.event.Cancellable;

public class ComponentEvent extends SystemEvent implements Cancellable {
    private final Component component;

    public ComponentEvent(ComponentSystem system, Component component) {
        super(system);
        this.component = component;
    }

    public Component getComponent() {
        return component;
    }
}