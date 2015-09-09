package example;

import me.exerosis.component.systemstate.SystemState;

/**
 * Created by The Exerosis on 8/26/2015.
 */
public enum ExampleSystemState implements SystemState {
    ENABLED, DISABLED;

    public static SystemState fromOrdinal(int ordinal) {
        return values()[ordinal];
    }

    public boolean equals(SystemState... states) {
        for (SystemState state : states)
            if (equals(state))
                return true;
        return false;
    }

    public SystemState getLast() {
        int index = ordinal() - 1;
        return fromOrdinal(index < 0 ? values().length - 1 : index);
    }

    public SystemState getNext() {
        int index = ordinal() + 1;
        return fromOrdinal(index >= values().length ? 0 : index);
    }
}
