package me.exerosis.component;

import me.exerosis.component.event.componet.ComponentDisableEvent;
import me.exerosis.component.event.componet.ComponentEnableEvent;
import me.exerosis.component.systemstate.ComponentSystemHolder;
import me.exerosis.reflection.event.EventManager;
import me.exerosis.reflection.pool.InstancePool;

public interface ComponentSystem {

    default EventManager getEventManager() {
        return ComponentSystemHolder.getEventManager(this);
    }

    default void setEventManager(EventManager manager) {
        ComponentSystemHolder.setEventManager(this, manager);
    }

    default Enum getSystemState() {
        return ComponentSystemHolder.getSystemState(this);
    }

    default void setSystemState(final Enum systemState) {
        ComponentSystemHolder.setSystemState(this, systemState);
    }

    default InstancePool getInstancePool() {
        return ComponentSystemHolder.getInstancePool(this);
    }

    default boolean doesFollowDependencyInjection() {
        return ComponentSystemHolder.doesFollowDependencyInjection(this);
    }

    default void setDoesFollowDependencyInjection(boolean doesFollowDependencyInjection) {
        ComponentSystemHolder.setDoesFollowDependencyInjection(this, doesFollowDependencyInjection);
    }

    // ComponentSystem Management
    default void enableSystem() {
        if (!doesFollowDependencyInjection())
            getInstancePool().setAllFields();

        final int[] count = {0};
        for (Object object : getInstancePool()) {
            if (!(object instanceof Component))
                continue;
            Component component = ((Component) object);
            getEventManager().callEvent(new ComponentEnableEvent(this, component), event -> {
                if (event.isCancelled())
                    return;
                count[0]++;
                component.onEnable();
            });
        }
        System.err.println("[ComponentSystem]Enabled a system:\n System Name: '" + toString() + "'\nComponent Count: '" + count[0] + "'");
    }

    default void disableSystem() {
        final int[] count = {0};
        for (Object object : getInstancePool()) {
            if (!(object instanceof Component))
                continue;
            Component component = ((Component) object);
            getEventManager().callEvent(new ComponentDisableEvent(this, component), event -> {
                if (event.isCancelled())
                    return;
                count[0]++;
                component.onDisable();
            });
        }
        System.err.println("[ComponentSystem]Disabled a system:\n System Name: '" + toString() + "'\nComponent Count: '" + count[0] + "'");
    }

    default void addInstance(Object... instances) {
        for (Object instance : instances) {
            if (instance instanceof Component)
                getInstancePool().addAllIfNotPresent(((Component) instance).getSubComponentsRecursively());
            getInstancePool().addIfNotPresent(instance);
        }
    }
}