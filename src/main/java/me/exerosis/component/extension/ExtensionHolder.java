package me.exerosis.component.extension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public interface ExtensionHolder {
    HashMap<ExtensionHolder, List<Extension>> instances = new HashMap<>();

    default Collection<Extension> getExtensions() {
        if (instances.get(this) == null)
            instances.put(this, new ArrayList<>());
        return instances.get(this);
    }

    default void addExtension(Extension extension) {
        getExtensions().add(extension);
    }

    default void removeExtension(Extension extension) {
        getExtensions().remove(extension);
    }

    default boolean containsExtension(Extension extension) {
        return getExtensions().contains(extension);
    }
}