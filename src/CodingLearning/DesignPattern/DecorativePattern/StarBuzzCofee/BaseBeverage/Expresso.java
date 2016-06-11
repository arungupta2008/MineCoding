package CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.BaseBeverage;

import CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.Beverage;

/**
 * Created by arun.gupta on 11/06/16.
 */
public class Expresso extends Beverage {

    public Expresso() {
        setDescription("Expresso");
    }

    @Override
    public double cost() {
        return 30.0;
    }
}
