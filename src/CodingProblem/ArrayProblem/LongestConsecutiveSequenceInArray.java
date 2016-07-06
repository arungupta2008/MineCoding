package CodingProblem.ArrayProblem;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by arun.gupta on 04/07/16.
 */

/*
* http://www.programcreek.com/2013/01/leetcode-longest-consecutive-sequence-java/
*
* Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example, given [100, 4, 200, 1, 3, 2], the longest consecutive elements sequence should be [1, 2, 3, 4]. Its length is 4.

Your algorithm should run in O(n) complexity.


Here complexity is O(N)


how ?

Every Time we remove one or more element.
If you derive from O(M*N) where N is Array Size and M is search Size Every time both M & N's Cardinality is Decreasing.
* */
public class LongestConsecutiveSequenceInArray {

    public static void main(String[] args) {
        int [] input = {100, 4, 1, 3, 2};
        LongestconsecutiveSubsequence(input);
    }

    private static void LongestconsecutiveSubsequence(int[] input) {
        Set<Integer> set = new HashSet<>();
        for (int in : input)
            set.add(in);

        int max = -1;
        for(int in : input){
            int left = in-1;
            int right = in+1;
            int count = 1;
            while (set.contains(left)){
                ++count;
                set.remove(left);
                --left;
            }

            while (set.contains(right)){
                ++count;
                set.remove(right);
                ++right;
            }
            max = Math.max(count,max);
        }

        System.out.println(" Max Size : "+ max);
    }
}
