package CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.BaseBeverage;

import CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.Beverage;
import CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.exception.SizeNotFoundException;

/**
 * Created by arun.gupta on 11/06/16.
 */
public class DarkRoast extends Beverage {

    public DarkRoast(Size size) {
        super.setSize(size);
        setDescription("Dark Raost");
    }

    @Override
    public double cost() throws SizeNotFoundException {
        switch (getSize()){
            case Small:
                return 10.0;
            case Medium:
                return 20.0;
            case Large:
                return 30.0;
            default: throw new SizeNotFoundException("Size not Found");
        }
    }
}
