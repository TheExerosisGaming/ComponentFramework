package me.exerosis.component;

import me.exerosis.component.events.system.SystemDisableEvent;
import me.exerosis.component.events.system.SystemEnableEvent;
import me.exerosis.component.factory.SystemFactory;

public class SystemHolder {
    private SystemFactory factory;
    private ComponentSystem currentSystem;

    // ComponentSystem management.
    public void nextSystem() {
        if (factory != null)
            setCurrentSystem(factory.getNextGame());
    }

    //System management.
    public void disableSystem() {
        if (currentSystem != null)
            currentSystem.getEventManager().callEvent(new SystemDisableEvent(currentSystem), event -> {
                if (event.isCancelled())
                    return;
                currentSystem.disableSystem();
            });
    }

    public void enableSystem(ComponentSystem system) {
        if (system == null)
            return;
        if (currentSystem != null)
            currentSystem.getEventManager().callEvent(new SystemEnableEvent(system), event -> {
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
        else {
            currentSystem = system;
            currentSystem.enableSystem();
        }
    }

    // Getters and setters.
    public void setCurrentSystem(ComponentSystem system) {
        disableSystem();
        enableSystem(system);
    }

    public SystemFactory getFactory() {
        return factory;
    }

    public void setFactory(SystemFactory factory) {
        this.factory = factory;
    }
}