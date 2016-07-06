package CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee;

import CodingLearning.DesignPattern.DecorativePattern.StarBuzzCofee.exception.SizeNotFoundException;

/**
 * Created by arun.gupta on 11/06/16.
 */
public abstract class Beverage {

    public enum Size{
        Small, Medium, Large;
    }

    String description = "No Beverage";
    Size size = null;

    public Size getSize(){
        return size;
    }

    public void setSize(Size size){
        this.size = size;
    }
    public String getDescription(){
        if(size == null){
            size = Size.Large;
        }
        return size.name() + " "+ description;
    }
    public void setDescription(String name){
        this.description = name;
    }
    public abstract double cost() throws SizeNotFoundException;
}
