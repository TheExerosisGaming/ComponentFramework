package example.component;

import me.exerosis.reflection.pool.InstancePool;

/**
 * Created by The Exerosis on 8/26/2015.
 */
public class TestDependComponent extends ExampleComponentWrapper {
    @InstancePool.Depend
    public TestComponent testComponent;
    @InstancePool.Depend
    public RepeatComponent repeatComponent;

    public TestDependComponent() {

    }

    @Override
    public void onEnable() {
        repeatComponent.setDelay(testComponent.getValue());
        System.out.println("Set delay to: " + testComponent.getValue());
    }

    @Override
    public void onDisable() {

    }
}
