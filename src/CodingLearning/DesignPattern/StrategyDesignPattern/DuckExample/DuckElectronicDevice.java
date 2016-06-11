package CodingLearning.DesignPattern.StrategyDesignPattern.DuckExample;

import CodingLearning.DesignPattern.StrategyDesignPattern.DuckExample.interfaceImpl.Quack;

/**
 * Created by arun.gupta on 03/06/16.
 */
public class DuckElectronicDevice extends DuckDevice {
    @Override
    public void display() {
        System.out.println("Quack Electronic Device");
    }

    public DuckElectronicDevice() {
        setQuackBehaviour(new Quack());
    }
}
