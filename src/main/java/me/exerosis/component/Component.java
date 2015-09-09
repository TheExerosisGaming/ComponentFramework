package me.exerosis.component;

import me.exerosis.reflection.util.Enableable;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by The Exerosis on 8/26/2015.
 */
public interface Component extends Enableable {
    default Collection<Component> getSubComponents() {
        return new ArrayList<>();
    }

    default Collection<Component> getSubComponentsRecursively() {
        Collection<Component> subComponents = getSubComponents();
        if (subComponents != null && !subComponents.isEmpty()) {
            for (Component component : subComponents) {
                if (!subComponents.contains(component))
                    subComponents.add(component);
                if (component.getSubComponents() != null && !component.getSubComponents().isEmpty())
                    getSubComponents().stream().filter(subComponent -> !subComponents.contains(subComponent)).forEach(subComponents::add);
            }
        }
        return subComponents;
    }
}
