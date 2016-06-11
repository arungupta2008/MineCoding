package CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.Condiments;

import CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.Beverage;
import CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.CondimentDecorator;

/**
 * Created by arun.gupta on 11/06/16.
 */
public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "Whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + 2.5;
    }
}
