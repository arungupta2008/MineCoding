package CodingProblem;

import java.util.BitSet;
import java.util.Scanner;

/**
 * Created by arun.gupta on 10/08/16.
 *
 *
 * A sequence of n > 0 integers is called a jolly jumper if the absolute values of the
 differences between successive elements take on all possible values 1 through n − 1. For
 instance,
 1 4 2 3
 is a jolly jumper, because the absolute diﬀerences are 3, 2, and 1, respectively. The
 deﬁnition implies that any sequence of a single integer is a jolly jumper. Write a program
 to determine whether each of a number of sequences is a jolly jumper.

 Input
 Each line of input contains an integer n < 3, 000 followed by n integers representing the
 sequence.

 Output
 For each line of input generate a line of output saying “Jolly” or “Not jolly”.

 Sample Input
 4 1 4 2 3
 5 1 4 2 -1 6
 Sample Output
 Jolly
 Not jolly

 Solution :
 We need to concentrate on the fact that difference in consecutive numbers should cover all number from 1 to n-1.
 The heart of solution is in selecting a data structure who's value at an index corresponding to the i (1 <= i < n) will be set
 if absolute value of difference between consecutive numbers is i. Absolute values of differences will fail to cover
 the range of 1 to n-1 if any of the difference value is repeated or any of the difference will fall out side the range
 of 1 to n-1 and there will be no need to check for the numbers further.

 Sample Input

 4 1 4 2 3
 5 1 4 2 -1 6
 Sample Output

 Jolly
 Not jolly

 */
public class JollyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){
            String input = sc.nextLine();
            if(input.trim().equals("")){
                break;
            }
            String [] inputStringList = input.split(" ");
            int inputSize = inputStringList.length;
            BitSet bitSet = new BitSet();
            boolean isJolly = true;
            for(int i =1 ; i< inputSize ; ++i){
                int diff = Math.abs(Integer.parseInt(inputStringList[i-1]) - Integer.parseInt(inputStringList[i]));
                if(diff < 1 || diff > inputSize || bitSet.get(diff)){
                    bitSet.clear();
                    isJolly = false;
                    break;
                }
            }
            if(!isJolly){
                System.out.println("Not Jolly");
            }else System.out.println("Jolly");

        }
    }
}
