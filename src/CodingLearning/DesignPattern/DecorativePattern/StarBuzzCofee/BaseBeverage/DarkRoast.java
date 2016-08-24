package CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.BaseBeverage;

import CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.Beverage;
import CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.exception.SizeNotFoundException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
        Set in  = new HashSet<>();
        in.add("df");
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
