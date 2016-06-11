package CodingLearning.DesignPattern.StrategyDesignPattern.DuckExample.interfaceImpl;

import CodingLearning.DesignPattern.StrategyDesignPattern.DuckExample.interfacees.Flyable;

/**
 * Created by arun.gupta on 03/06/16.
 */
public class FlyWithWings implements Flyable{

    @Override
    public void fly() {
        System.out.println("Have wings to Fly");
    }
}
