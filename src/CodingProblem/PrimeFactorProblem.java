package CodingProblem;

import java.util.*;
/**
 * Created by arun.gupta on 08/07/16.
 *
 * 	36.  Given three prime number(p1, p2, p3) and an integer k. Find the first(smallest) k integers which have only p1, p2, p3 or a combination of them as their prime factors.

 */
public class PrimeFactorProblem {

    public static void main(String[] args) {
        int n = 10;
        int [] input = {3,5,7};
        printAllNumbers(input,n);
    }

    private static void printAllNumbers(int[] input, int n) {
        HashSet<Integer> values = new HashSet<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(Integer inputInteger : input){
            minHeap.offer(inputInteger);
            System.out.println(minHeap.toString());
            values.add(inputInteger);
        }
        int count = minHeap.size();
        List<Integer> solutionList = new ArrayList<>();
        while (minHeap.size() > 0){
            int root = minHeap.poll();
            if(count < n) {
                for (Integer inputInteger : input) {
                    if(!values.contains(inputInteger * root)) {
                        minHeap.offer(inputInteger * root);
                        System.out.println(minHeap.toString());
                        values.add(inputInteger * root);
                        ++count;
                    }
                }
            }
            solutionList.add(root);
        }
        System.out.println(solutionList);
    }
}


