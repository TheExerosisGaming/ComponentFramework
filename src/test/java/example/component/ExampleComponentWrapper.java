package example.component;

import me.exerosis.component.Component;
import me.exerosis.component.SystemHolder;
import me.exerosis.reflection.pool.InstancePool;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by The Exerosis on 8/26/2015.
 */
public class ExampleComponentWrapper implements Component {
    boolean enabled;
    @InstancePool.Depend
    private SystemHolder holder;
    private Component[] components;

    public ExampleComponentWrapper(Component... components) {
        this.components = components;
    }

    @Override
    public Collection<Component> getSubComponents() {
        return Arrays.asList(components);
    }

    public SystemHolder getHolder() {
        return holder;
    }

    @Override
    public void onEnable() {
        enabled = true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void onDisable() {
        enabled = false;
    }
}
