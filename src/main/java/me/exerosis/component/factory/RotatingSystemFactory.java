package me.exerosis.component.factory;

import me.exerosis.component.ComponentSystem;

public class RotatingSystemFactory implements SystemFactory {
    private ComponentSystem[] systems;
    private int counter = 0;

    public RotatingSystemFactory(ComponentSystem... systems) {
        this.systems = systems;
    }

    public ComponentSystem getNextGame() {
        return systems[counter >= systems.length - 1 ? counter = 0 : counter++];
    }
}
