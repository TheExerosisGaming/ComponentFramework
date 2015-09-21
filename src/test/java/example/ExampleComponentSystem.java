package example;

import example.component.RepeatComponent;
import example.component.TestComponent;
import example.component.TestDependComponent;
import example.component.ValuePassingComponent;
import me.exerosis.component.ComponentSystem;

public class ExampleComponentSystem implements ComponentSystem {

    public ExampleComponentSystem() {
        addInstance(new TestComponent(1000));
        addInstance(new TestDependComponent());
        ValuePassingComponent component = new ValuePassingComponent("This is the default message!");
        addInstance(component);
        addInstance(new RepeatComponent(component));
        setDoesFollowDependencyInjection(true);
    }
}
