package CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.BaseBeverage;

import CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.Beverage;

/**
 * Created by arun.gupta on 11/06/16.
 */
public class Decaf extends Beverage {

    public Decaf() {
        setDescription("Decaf");
    }

    @Override
    public double cost() {
        return 25.0;
    }
}
