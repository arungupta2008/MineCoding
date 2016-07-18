package AlgorithmProblems;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by arun.gupta on 24/04/16.
 *
 * Balanced Partition Problem – Finding the minimized sum between two partitions of a set of positive integers
 *
 * https://chinmaylokesh.wordpress.com/2011/02/10/balanced-partition-problem-finding-the-minimized-sum-between-two-partitions-of-a-set-of-positive-integers/
 *
 * It only prints how much the  Diff would be if Two list are partitioned.
 */
public class ArrayPartitionProblem {

    public static void main(String[] args) throws IOException {

        int sum = 0;
        System.out.println("Enter the number of inputArray elements");
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] inputArray = new int[N];
        System.out.println("Enter the Positive elements of the inputArray");
        for (int member = 0; member < N; member++) {
            inputArray[member] = input.nextInt();
            sum += inputArray[member];
        }

        boolean[] sol = new boolean[sum / 2 + 1];

        sol[0] = true;//empty inputArray
        for (int i : inputArray) {
            for (int j = sum / 2; j >= i; j--) {
                System.out.println("Sum : "+sum);
                System.out.println("i : "+i+ " J : "+j);

                if (sol[j - i]) {
                    sol[j] = true;
                }
                System.out.println("sol : "+ Arrays.toString(sol));
                System.out.println("\n\n");
            }
        }

        int halfsumcloser = sum / 2;
        for (; !sol[halfsumcloser]; halfsumcloser--) {
            System.out.println("halfsumcloser : " + halfsumcloser);
        }
        System.out.println("halfsumcloser--  : " + halfsumcloser);
        System.out.println("The Minimum sum After partioning the inputArray is :" + ((sum - halfsumcloser) - halfsumcloser));

    }
}
