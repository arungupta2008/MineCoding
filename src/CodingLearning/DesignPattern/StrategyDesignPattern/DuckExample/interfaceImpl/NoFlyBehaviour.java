package CodingLearning.DesignPattern.StrategyDesignPattern.DuckExample.interfaceImpl;

import CodingLearning.DesignPattern.StrategyDesignPattern.DuckExample.interfacees.Flyable;

/**
 * Created by arun.gupta on 03/06/16.
 */
public class NoFlyBehaviour implements Flyable {
    @Override
    public void fly() {
        System.out.println("This Duck can not Fly");
    }
}
