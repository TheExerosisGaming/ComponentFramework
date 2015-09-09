package example.component;

/**
 * Created by The Exerosis on 8/26/2015.
 */
public class ValuePassingComponent extends ExampleComponentWrapper {
    private String defaultValue;

    public ValuePassingComponent(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getValue() {
        return defaultValue;
    }

    public void setValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public void onEnable() {
        System.out.println("Value passing component was enabled!");
    }
}
