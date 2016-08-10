package CodingProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by arun.gupta on 09/08/16.
 *
 * Booking.com
 *
 * Given a A B C D distance of four Quadrilateral find if it is Rectangle or Square or Others
 * Return me the Count
 * Input
 36 30 36 30
 15 15 15 15
 46 96 90 100
 86 86 86 86
 100 200 100 200
 -100 200 -100 200

 OutPut
 2 2 2
 */

public class CountQuadrilateralType {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int square = 0;
        int rectangle = 0;
        int otherOrNone = 0;

        List<Integer> quadrilateralInputDistance = new ArrayList<Integer>();

        try{
            while(sc.hasNextLine()) {
                String tempLine = sc.nextLine();
                if (tempLine.equals("")){
                    break;
                }
                String [] inputNumbers = tempLine.split(" ");
                quadrilateralInputDistance.clear();
                quadrilateralInputDistance.add(Integer.valueOf(inputNumbers[0]));
                quadrilateralInputDistance.add(Integer.valueOf(inputNumbers[1]));
                quadrilateralInputDistance.add(Integer.valueOf(inputNumbers[2]));
                quadrilateralInputDistance.add(Integer.valueOf(inputNumbers[3]));

                if(quadrilateralInputDistance.get(0) <= 0 || quadrilateralInputDistance.get(1) <= 0 || quadrilateralInputDistance.get(2) <= 0 || quadrilateralInputDistance.get(3) <= 0)
                    otherOrNone++;
                else if(quadrilateralInputDistance.get(0).equals(quadrilateralInputDistance.get(1)) && quadrilateralInputDistance.get(1).equals(quadrilateralInputDistance.get(2)) && quadrilateralInputDistance.get(2).equals(quadrilateralInputDistance.get(3)))
                    square++;
                else if(((quadrilateralInputDistance.get(0).equals(quadrilateralInputDistance.get(2)) && (quadrilateralInputDistance.get(1).equals(quadrilateralInputDistance.get(3))))))
                    rectangle++;
                else
                    otherOrNone++;
            }
        } catch (Exception e) {
        }
        System.out.println(square + " " + rectangle + " " + otherOrNone);
    }
}
