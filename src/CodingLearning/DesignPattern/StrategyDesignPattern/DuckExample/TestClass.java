package CodingLearning.DesignPattern.StrategyDesignPattern.DuckExample;

import CodingLearning.DesignPattern.StrategyDesignPattern.DuckExample.interfaceImpl.FlyWithWings;

/**
 * Created by arun.gupta on 03/06/16.
 */
public class TestClass {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck(); // This is called Upcasting.

        mallardDuck.display();
        mallardDuck.peformQuack();
        mallardDuck.performFly();

        mallardDuck.setFlyableBehaviour(new FlyWithWings());
        System.out.print("Now ");
        mallardDuck.performFly();

        DuckDevice duckDevice = new DuckElectronicDevice();
        duckDevice.display();
        duckDevice.performQuack();

    }
}
