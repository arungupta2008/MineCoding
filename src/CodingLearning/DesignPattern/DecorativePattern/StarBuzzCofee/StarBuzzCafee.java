package CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee;

import CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.BaseBeverage.DarkRoast;
import CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.BaseBeverage.Expresso;
import CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.BaseBeverage.HouseBlend;
import CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.Condiments.Milk;
import CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.Condiments.Moca;
import CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.Condiments.Soy;
import CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.Condiments.Whip;

/**
 * Created by arun.gupta on 11/06/16.
 */
public class StarBuzzCafee {

    public static void main(String[] args) {
        try {
            Beverage expresso = new Expresso();
            Beverage houseBlend = new HouseBlend();

            System.out.println(expresso.getDescription() + " @ " + expresso.cost());
            expresso = new Milk(expresso);
            System.out.println(expresso.getDescription() + " @ " + expresso.cost());
            expresso = new Milk(expresso);
            System.out.println(expresso.getDescription() + " @ " + expresso.cost());

            System.out.println(houseBlend.getDescription() + " @ " + houseBlend.cost());
            houseBlend = new Moca(houseBlend);
            System.out.println(houseBlend.getDescription() + " @ " + houseBlend.cost());
            houseBlend = new Soy(houseBlend);
            System.out.println(houseBlend.getDescription() + " @ " + houseBlend.cost());
            houseBlend = new Whip(houseBlend);
            System.out.println(houseBlend.getDescription() + " @ " + houseBlend.cost());

            Beverage darkRoast = new DarkRoast(Beverage.Size.Medium);
            System.out.println(darkRoast.getDescription() + " @ " + darkRoast.cost());
            darkRoast = new Milk(darkRoast);
            System.out.println(darkRoast.getDescription() + " @ " + darkRoast.cost());

        }catch (Exception e){
            System.out.println(String.format("Error : %s",e.getMessage()));
        }

    }
}
