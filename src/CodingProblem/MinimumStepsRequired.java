package CodingProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by arun.gupta on 09/07/16.
 *
 * #You are in an infinite 2D grid where you can move in any of the 8 directions :
 #(x,y) to
 #    (x+1, y),
 #    (x - 1, y),
 #    (x, y+1),
 #    (x, y-1),
 #    (x-1, y-1),
 #    (x+1,y+1),
 #    (x-1,y+1),
 #    (x+1,y-1)
 #You are given a sequence of points and the order in which you need to cover the points.
 #Give the minimum number of steps in which you can achieve it. You start from the first point.
 */
class TwoDPoint{
    Vector<Integer> point = new Vector<>(2);
    public TwoDPoint(int x, int y) {
        point.add(x);
        point.add(y);
    }
    public int getXPoint(){
        return point.get(0);
    }
    public int getYPoint(){
        return point.get(1);
    }
}
public class MinimumStepsRequired {
    public static void main(String[] args) {
        List<TwoDPoint> points = new ArrayList<>();
//        points.add(new TwoDPoint(0,0));
//        points.add(new TwoDPoint(1,1));
//        points.add(new TwoDPoint(1,2));

//        points.add(new TwoDPoint(5,20));
//        points.add(new TwoDPoint(15,15));
        //points.add(new TwoDPoint(1,2));

        points.add(new TwoDPoint(4,4));
        points.add(new TwoDPoint(8,-15));
        points.add(new TwoDPoint(-7,-10));
        points.add(new TwoDPoint(-5,-3));
        points.add(new TwoDPoint(-13,-13));
        points.add(new TwoDPoint(9,12));
        points.add(new TwoDPoint(-7,8));
        points.add(new TwoDPoint(8,-8));



        calculateMinSteps(points);

        ArrayList<Integer> X = new ArrayList<>();
        X.add(4);
        X.add(8);
        X.add(-7);
        X.add(-5);
        X.add(-13);
        X.add(9);
        X.add(-7);
        X.add(8);

        ArrayList<Integer> Y = new ArrayList<>();
        Y.add(4);
        Y.add(-15);
        Y.add(-10);
        Y.add(-3);
        Y.add(-13);
        Y.add(12);
        Y.add(8);
        Y.add(-8);

        System.out.println("sdsdf : "+ coverPoints(X,Y));
    }

    private static void calculateMinSteps(List<TwoDPoint> points) {
        int totalSteps = 0;
        int x = points.get(0).getXPoint();
        int y = points.get(0).getYPoint();
        for (int i =1; i< points.size(); ++i){
            totalSteps += Math.max(Math.abs(x-points.get(i).getXPoint()), Math.abs(y-points.get(i).getYPoint()));
            x = points.get(i).getXPoint();
            y = points.get(i).getYPoint();
            System.out.println("Steps : "+totalSteps);
        }
        System.out.println("Steps : "+totalSteps);
    }

    public static int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int x = X.get(0);
        int y = Y.get(0);
        int totalSteps = 0;
        if(X.size() == 1){
            return 0;
        }
        for(int i = 1; i < X.size(); ++i){
            totalSteps += Math.max(Math.abs(x-X.get(i)), Math.abs(y-Y.get(i)));
            x = X.get(i);
            y = Y.get(i);
            System.out.println("Steps : "+totalSteps);
        }
        return totalSteps;
    }
}
