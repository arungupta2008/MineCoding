package CodingProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by arun.gupta on 02/08/16.
 *
 * input : 25626 25757 24367 24267 16 100 2 7277
 * Booking.com
 */
public class DeltaEncoding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Long> input = new ArrayList<>();
        String inputLine = scanner.nextLine();
        String [] inputString =  inputLine.split(" ");

        int i = 1;
        System.out.print(inputString[i-1]+" ");
        while (i<inputString.length){
            Long diff = Long.valueOf(inputString[i])-Long.valueOf(inputString[i-1]);
            if(Math.abs(diff) >127){
                System.out.print("-128" + " ");
            }
            System.out.print(diff+" ");
            ++i;
        }
    }
}
