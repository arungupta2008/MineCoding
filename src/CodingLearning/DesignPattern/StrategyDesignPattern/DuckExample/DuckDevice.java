package CodingLearning.DesignPattern.StrategyDesignPattern.DuckExample;

import CodingLearning.DesignPattern.StrategyDesignPattern.DuckExample.interfacees.Quackable;

/**
 * Created by arun.gupta on 03/06/16.
 */
public abstract class DuckDevice {
    public Quackable quackBehaviour;

    public abstract void display();

    public void performQuack(){
        quackBehaviour.quack();
    }

    public void setQuackBehaviour(Quackable quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }
}
