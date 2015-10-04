package me.exerosis.component.events.system;

import me.exerosis.component.ComponentSystem;

public class SystemEvent {
    private ComponentSystem system;

    public SystemEvent(ComponentSystem system) {
        this.system = system;
    }

    public ComponentSystem getSystem() {
        return system;
    }

    public void setSystem(ComponentSystem system) {
        this.system = system;
    }
}
