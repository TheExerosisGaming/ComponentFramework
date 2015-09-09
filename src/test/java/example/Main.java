package example;

import me.exerosis.component.SystemHolder;
import me.exerosis.component.factory.RotatingSystemFactory;

/**
 * Created by The Exerosis on 8/26/2015.
 */
public class Main {
    public static void main(String[] args) {
        new SystemHolder(new RotatingSystemFactory(new ExampleComponentSystem(), new ExampleComponentSystemTwo())).nextSystem();
    }
}
