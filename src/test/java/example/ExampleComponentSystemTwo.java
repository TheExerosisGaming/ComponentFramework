package example;

import example.component.TestComponent;
import me.exerosis.component.ComponentSystem;
import me.exerosis.reflection.event.EventManager;
import me.exerosis.reflection.pool.InstancePool;

/**
 * Created by The Exerosis on 8/26/2015.
 */
public class ExampleComponentSystemTwo implements ComponentSystem {
    InstancePool pool = new InstancePool();
    EventManager eventManager = new EventManager();

    public ExampleComponentSystemTwo() {
        addInstance(new TestComponent(10000));
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
