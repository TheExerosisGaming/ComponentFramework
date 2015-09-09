package me.exerosis.component;

import me.exerosis.component.event.system.SystemDisableEvent;
import me.exerosis.component.event.system.SystemEnableEvent;
import me.exerosis.component.event.system.SystemStateChangeEvent;
import me.exerosis.component.factory.SystemFactory;
import me.exerosis.reflection.event.EventManager;

public class SystemHolder {
    private EventManager eventManager = new EventManager();
    private SystemFactory factory;

    // SystemHolder fields.
    private ComponentSystem currentSystem;
    private Enum currentSystemState;

    public SystemHolder(SystemFactory factory) {
        this.factory = factory;
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    // ComponentSystem management.
    public void nextSystem() {
        setCurrentSystem(factory.getNextGame());
    }


    // Getters and setters.
    public void disableSystem() {
        if (currentSystem != null)
            eventManager.callEvent(new SystemDisableEvent(currentSystem), event -> {
                if (event.isCancelled())
                    return;
                currentSystem.disableSystem();
                nextSystem();
            });
    }

    public void enableSystem(ComponentSystem system) {
        eventManager.callEvent(new SystemEnableEvent(system), event -> {
            if (event.isCancelled())
                return;

            //Enable
            currentSystem = system;

            if (!currentSystem.doesFollowDependencyInjection()) {
                currentSystem.getInstancePool().addIfNotPresent(currentSystem);
                currentSystem.getInstancePool().addIfNotPresent(this);
            }
            currentSystem.enableSystem();
        });
    }

    public void setCurrentSystem(ComponentSystem system) {
        disableSystem();
        enableSystem(system);
    }

    public Enum getSystemState() {
        return currentSystemState;
    }

    public void setSystemState(final Enum newSystemState) {
        eventManager.callEvent(new SystemStateChangeEvent(currentSystem, currentSystemState, newSystemState), event -> currentSystemState = event.getNewSystemState());
    }

    public SystemFactory getFactory() {
        return factory;
    }

    public void setFactory(SystemFactory factory) {
        this.factory = factory;
    }
}
