package CodingProblem;


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arun.gupta on 22/07/16.
 *
 * Given 4 Sides, Find out  if it is find if it is rectangle square or qudrilateral.
 */
public class FindQuadrilateralType {
    public static void main(String[] args) {
        List<Pair<Integer,Integer>> points = new ArrayList<>();

//        points.add(new Pair<>(10,10));
//        points.add(new Pair<>(20,10));
//        points.add(new Pair<>(20,20));
//        points.add(new Pair<>(10,20));

//        points.add(new Pair<>(10,10));
//        points.add(new Pair<>(30,10));
//        points.add(new Pair<>(30,20));
//        points.add(new Pair<>(10,20));


        points.add(new Pair<>(10,10));
        points.add(new Pair<>(30,10));
        points.add(new Pair<>(30,30));
        points.add(new Pair<>(10,20));

        findQuadrilateralType(points);
    }

    private static void findQuadrilateralType(List<Pair<Integer, Integer>> points) {
        double distance1 = findDistance(points.get(0), points.get(1));
        double distance2 = findDistance(points.get(0), points.get(2));
        double distance3 = findDistance(points.get(0), points.get(3));
        double diagonalDistance1 = 0.0;
        double diagonalDistance2 = 0.0;

        if(Double.compare(distance1,distance2) != 0 && Double.compare(distance1,distance3) != 0 ){
            // Digonals will always have longest Side.
            Pair<Integer, Integer> diagonalPair = null;
            if(Double.compare(distance1,distance2) > 0){
                if(Double.compare(distance1,distance3) > 0){
                    // distance1 is Diagonal
                    diagonalPair = new Pair<>(0,1);
                    diagonalDistance1 = distance1;
                    diagonalDistance2 = findDistance(points.get(2), points.get(3));
                }else {
                    // distance3 is Diagonal
                    diagonalDistance1 = distance3;
                    diagonalDistance2 = findDistance(points.get(2), points.get(1));
                    diagonalPair = new Pair<>(0,3);
                }
            }else {
                if(Double.compare(distance2,distance3) > 0){
                    // distance2 is Diagonal
                    diagonalPair = new Pair<>(0,2);
                    diagonalDistance1 = distance2;
                    diagonalDistance2 = findDistance(points.get(1), points.get(3));
                }else {
                    // distance3 is Diagonal
                    diagonalPair = new Pair<>(0,3);
                    diagonalDistance1 = distance3;
                    diagonalDistance2 = findDistance(points.get(2), points.get(1));
                }
            }
            if(Double.compare(diagonalDistance1, diagonalDistance2) == 0){
                System.out.println("It's a Rectangle");
            }else System.out.println("It's a Quadrilateral");
        }
        if(Double.compare(distance1,distance2) == 0){
            if(Double.compare(distance3, findDistance(points.get(1), points.get(2))) == 0) {
                System.out.println("It's a Square");
            }
        }
        if(Double.compare(distance1,distance3) == 0){
            if(Double.compare(distance2, findDistance(points.get(1), points.get(3))) == 0){
                System.out.println("It's a Square");
            }
        }
        if(Double.compare(distance2,distance3) == 0){
            if(Double.compare(distance1, findDistance(points.get(2), points.get(3))) == 0){
                System.out.println("It's a Square");
            }
        }

    }

    private static double findDistance(Pair<Integer, Integer> input1, Pair<Integer, Integer> input2) {
        return Math.sqrt( Math.pow(input1.getKey() - input2.getKey(), 2) + Math.pow(input1.getValue() - input2.getValue()
                , 2));
    }
}
