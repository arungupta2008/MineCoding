package CodingLearning.DesignPattern.StrategyDesignPattern.DuckExample;

import CodingLearning.DesignPattern.StrategyDesignPattern.DuckExample.interfacees.Flyable;
import CodingLearning.DesignPattern.StrategyDesignPattern.DuckExample.interfacees.Quackable;

/**
 * Created by arun.gupta on 03/06/16.
 */
public abstract class Duck {
    private Flyable flyableBehaviour;
    private Quackable quackBehaviour;

    public void swim(){
        System.out.println("Every One Can Swim");
    }

    public abstract void display();

    public void performFly(){
        flyableBehaviour.fly();
    }

    public void peformQuack(){
        quackBehaviour.quack();
    }

    public void setFlyableBehaviour(Flyable flyableBehaviour) {
        this.flyableBehaviour = flyableBehaviour;
    }

    public void setQuackBehaviour(Quackable quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }
}
