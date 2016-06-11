package CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.BaseBeverage;

import CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.Beverage;

/**
 * Created by arun.gupta on 11/06/16.
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        setDescription("Dark Raost");
    }


    @Override
    public double cost() {
        return 30.0;
    }
}
