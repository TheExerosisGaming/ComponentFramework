package example;

import example.component.RepeatComponent;
import example.component.TestComponent;
import example.component.TestDependComponent;
import example.component.ValuePassingComponent;
import me.exerosis.component.ComponentSystem;
import me.exerosis.reflection.event.EventManager;
import me.exerosis.reflection.pool.InstancePool;

/**
 * Created by The Exerosis on 8/26/2015.
 */
public class ExampleComponentSystem implements ComponentSystem {
    InstancePool pool = new InstancePool();
    EventManager eventManager = new EventManager();

    public ExampleComponentSystem() {
        addInstance(new TestComponent(1000));
        addInstance(new TestDependComponent());
        ValuePassingComponent component = new ValuePassingComponent("This is the default message!");
        addInstance(component);
        addInstance(new RepeatComponent(component));
    }

    @Override
    public EventManager getEventManager() {
        return eventManager;
    }

    @Override
    public InstancePool getInstancePool() {
        return pool;
    }
}
