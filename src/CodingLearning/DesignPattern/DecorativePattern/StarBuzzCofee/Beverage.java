package CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee;

/**
 * Created by arun.gupta on 11/06/16.
 */
public abstract class Beverage {


    String description = "No Beverage";
    public String getDescription(){
        return description;
    }
    public void setDescription(String name){
        this.description = name;
    }
    public abstract double cost();
}
