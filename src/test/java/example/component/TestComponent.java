package example.component;

/**
 * Created by The Exerosis on 8/26/2015.
 */
public class TestComponent extends ExampleComponentWrapper {
    private int value;

    public TestComponent(int value) {
        super(new InputListenerSubComponent(value));
        this.value = value;
        System.out.println("A new instance of the test component was created!");
    }

    public int getValue() {
        return value;
    }

    @Override
    public void onEnable() {
        System.out.println("Test component was enabled!");
    }

    @Override
    public void onDisable() {
        System.out.println("Test component was disabled!");
    }
}
