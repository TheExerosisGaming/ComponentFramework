package me.exerosis.component.event.componet;

import me.exerosis.component.Component;
import me.exerosis.component.ComponentSystem;

/**
 * Created by The Exerosis on 8/26/2015.
 */
public class ComponentEnableEvent extends ComponentEvent {
    public ComponentEnableEvent(ComponentSystem system, Component component) {
        super(system, component);
    }
}
