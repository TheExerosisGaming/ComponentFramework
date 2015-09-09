package me.exerosis.component.event.system;

import me.exerosis.component.ComponentSystem;

public class SystemStateChangeEvent extends SystemEvent {
    private Enum newSystemState;
    private Enum oldSystemState;

    public SystemStateChangeEvent(ComponentSystem system, Enum oldSystemState, Enum newSystemState) {
        super(system);
        this.oldSystemState = oldSystemState;
        this.newSystemState = newSystemState;
    }

    public Enum getNewSystemState() {
        return newSystemState;
    }

    public void setNewSystemState(Enum newSystemState) {
        this.newSystemState = newSystemState;
    }

    public Enum getOldSystemState() {
        return oldSystemState;
    }
}
