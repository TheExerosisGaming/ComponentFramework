package me.exerosis.component.events.system;

import me.exerosis.component.ComponentSystem;
import me.exerosis.event.Cancellable;

public class SystemEnableEvent extends SystemEvent implements Cancellable {
    public SystemEnableEvent(ComponentSystem system) {
        super(system);
    }
}