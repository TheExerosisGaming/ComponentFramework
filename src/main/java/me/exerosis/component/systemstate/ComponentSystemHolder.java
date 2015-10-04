package me.exerosis.component.systemstate;

import me.exerosis.component.ComponentSystem;
import me.exerosis.component.event.EventManager;
import me.exerosis.component.events.system.SystemStateChangeEvent;
import me.exerosis.reflection.pool.InstancePool;

import java.util.Map;
import java.util.WeakHashMap;

public class ComponentSystemHolder {

    private static Map<ComponentSystem, PseudoInstance> instances = new WeakHashMap<>();

    private ComponentSystemHolder() {
    }

    public static EventManager getEventManager(ComponentSystem instance) {
        return getInstance(instance).getEventManager();
    }

    public static void setEventManager(ComponentSystem instance, EventManager eventManager) {
        getInstance(instance).setEventManager(eventManager);
    }

    public static Enum getSystemState(ComponentSystem instance) {
        return getInstance(instance).getSystemState();
    }

    public static void setSystemState(ComponentSystem instance, final Enum systemState) {
        getInstance(instance).setSystemState(systemState);
    }

    public static InstancePool getInstancePool(ComponentSystem instance) {
        return getInstance(instance).getInstancePool();
    }

    public static boolean doesFollowDependencyInjection(ComponentSystem instance) {
        return getInstance(instance).doesFollowDependencyInjection();
    }

    public static void setDoesFollowDependencyInjection(ComponentSystem instance, boolean doesFollowDependencyInjection) {
        getInstance(instance).setDoesFollowDependencyInjection(doesFollowDependencyInjection);
    }

    @SuppressWarnings("unchecked")
    private static PseudoInstance getInstance(ComponentSystem instance) {
        PseudoInstance pseudoInstance = instances.get(instance);
        if (pseudoInstance != null)
            return pseudoInstance;
        pseudoInstance = new PseudoInstance(instance);
        instances.put(instance, pseudoInstance);
        return pseudoInstance;
    }


    public static class PseudoInstance {
        private final ComponentSystem instance;
        private final InstancePool instancePool = new InstancePool();
        private EventManager eventManager = new EventManager();
        private Enum currentSystemState;
        private boolean doesFollowDependencyInjection;

        public PseudoInstance(final ComponentSystem instance) {
            this.instance = instance;
        }

        public boolean doesFollowDependencyInjection() {
            return doesFollowDependencyInjection;
        }

        public void setDoesFollowDependencyInjection(boolean doesFollowDependencyInjection) {
            this.doesFollowDependencyInjection = doesFollowDependencyInjection;
        }

        public InstancePool getInstancePool() {
            return instancePool;
        }

        public EventManager getEventManager() {
            return eventManager;
        }

        public void setEventManager(EventManager eventManager) {
            this.eventManager = eventManager;
        }

        public Enum getSystemState() {
            return currentSystemState;
        }

        public void setSystemState(final Enum newSystemState) {
            if (!newSystemState.equals(currentSystemState))
                eventManager.callEvent(new SystemStateChangeEvent(instance, currentSystemState, newSystemState), event -> currentSystemState = event.getNewSystemState());
        }
    }
}