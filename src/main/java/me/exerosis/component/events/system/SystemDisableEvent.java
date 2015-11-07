package me.exerosis.component.events.system;

import me.exerosis.component.ComponentSystem;
import me.exerosis.event.Cancellable;

public class SystemDisableEvent extends SystemEvent implements Cancellable {
    public SystemDisableEvent(ComponentSystem system) {
        super(system);
    }
}