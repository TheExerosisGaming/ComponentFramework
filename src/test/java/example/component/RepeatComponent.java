package example.component;

/**
 * Created by The Exerosis on 8/26/2015.
 */
public class RepeatComponent extends ExampleComponentWrapper {
    int delay = 10000;
    int count;
    private ValuePassingComponent valuePassingComponent;

    public RepeatComponent(ValuePassingComponent valuePassingComponent) {
        this.valuePassingComponent = valuePassingComponent;
        System.out.println("A new instance of the repeat component was created!");
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    @Override
    public void onEnable() {
        System.out.println("Repeat component was enabled!");
        while (isEnabled()) {
            System.out.println("Printed from repeater" + valuePassingComponent.getValue());
            if (count++ == 40)
                getHolder().nextSystem();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDisable() {
        System.out.println("Repeat component was disabled!");
    }
}
