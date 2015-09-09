package me.exerosis.component.factory;

import me.exerosis.component.ComponentSystem;

import java.util.Random;

public class RandomSystemFactory implements SystemFactory {
    public static final Random RANDOM = new Random();
    private ComponentSystem[] systems;
    private ComponentSystem lastSystem;

    public RandomSystemFactory(ComponentSystem... systems) {
        this.systems = systems;
    }

    public ComponentSystem getNextGame() {
        ComponentSystem newSystem = pickRandom();
        while (lastSystem.equals(newSystem))
            newSystem = pickRandom();
        return lastSystem = newSystem;
    }

    private ComponentSystem pickRandom() {
        return systems[RANDOM.nextInt(systems.length - 1)];
    }
}
