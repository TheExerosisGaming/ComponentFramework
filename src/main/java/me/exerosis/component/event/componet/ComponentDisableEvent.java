package me.exerosis.component.event.componet;

import me.exerosis.component.Component;
import me.exerosis.component.ComponentSystem;

/**
 * Created by The Exerosis on 8/26/2015.
 */
public class ComponentDisableEvent extends ComponentEvent {
    public ComponentDisableEvent(ComponentSystem system, Component component) {
        super(system, component);
    }
}
