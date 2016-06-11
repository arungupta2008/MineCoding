package CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.BaseBeverage;

import CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.Beverage;

/**
 * Created by arun.gupta on 11/06/16.
 */
public class HouseBlend extends Beverage {

    public HouseBlend(){
        setDescription("House Blend");
    }
    @Override
    public double cost() {
        return 20.00;
    }
}
