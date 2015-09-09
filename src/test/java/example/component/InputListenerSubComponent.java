package example.component;

import me.exerosis.reflection.pool.InstancePool;

import java.util.Scanner;

/**
 * Created by The Exerosis on 8/26/2015.
 */
public class InputListenerSubComponent extends ExampleComponentWrapper {
    private String repeatValue;
    private int parentValue;
    @InstancePool.Depend
    private ValuePassingComponent valuePassingComponent;

    public InputListenerSubComponent(int aValueFromAParent) {
        parentValue = aValueFromAParent;
        System.out.println("A new instance of the test sub component was created! And it got value: " + aValueFromAParent);
    }

    public String getValue() {
        return repeatValue + " delay: " + parentValue;
    }

    @Override
    public void onEnable() {
        System.out.println("Listener component component was enabled!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a value to be repeated by the repeater :D");
        valuePassingComponent.setValue(scanner.nextLine());
    }

    @Override
    public void onDisable() {
        System.out.println("Listener sub component was disabled!");
    }
}
