package CodingLearning.DesignPattern.StrategyDesignPattern.DuckExample.interfaceImpl;

import CodingLearning.DesignPattern.StrategyDesignPattern.DuckExample.interfacees.Quackable;

/**
 * Created by arun.gupta on 03/06/16.
 */
public class MuteQuack implements Quackable {

    @Override
    public void quack() {
        System.out.println("Mute Quack");
    }
}
