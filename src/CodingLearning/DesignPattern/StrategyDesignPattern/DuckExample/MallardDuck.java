package CodingLearning.DesignPattern.StrategyDesignPattern.DuckExample;

import CodingLearning.DesignPattern.StrategyDesignPattern.DuckExample.interfaceImpl.NoFlyBehaviour;
import CodingLearning.DesignPattern.StrategyDesignPattern.DuckExample.interfaceImpl.Quack;

/**
 * Created by arun.gupta on 03/06/16.
 */
public class MallardDuck extends Duck {

    @Override
    public void display() {
        System.out.println("Loocks like mallard Duck");
    }

    public MallardDuck() {
        setFlyableBehaviour(new NoFlyBehaviour());
        setQuackBehaviour(new Quack());
    }
}
