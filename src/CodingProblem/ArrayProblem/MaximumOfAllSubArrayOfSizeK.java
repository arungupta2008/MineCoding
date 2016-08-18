package CodingProblem.ArrayProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by arun.gupta on 13/07/16.
 * <p>
 * Maximum of all subarrays of size k (Added a O(n) method)
 * Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.
 * <p>
 * Examples:
 * <p>
 * Input :
 * arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
 * k = 3
 * Output :
 * 3 3 4 5 5 5 6
 * <p>
 * Input :
 * arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}
 * k = 4
 * Output :
 * 10 10 10 15 15 90 90
 * <p>
 * <p>
 * <p>
 * <p>
 * We create a Dequeue, Qi of capacity k, that stores only useful elements of current window of k elements. An
 * element is useful if it is in current window and is greater than all other elements on left side of it in current
 * window. We process all array elements one by one and maintain Qi to contain useful elements of current window and
 * these useful elements are maintained in sorted order. The element at front of the Qi is the largest and element at
 * rear of Qi is the smallest of current window.
 *
 *
 * Same we can solve it for the Minimum Queue.
 */
public class MaximumOfAllSubArrayOfSizeK {
    public static void main(String[] args) {
        int [] inputArray = {3,5,6,4,2,4,5,6,4,3,2,4,5,6};
        //int [] inputArray = {3,2,5,2,1,5};
//        int[] inputArray = {3, 2, 3, 2, 5, 6, 7, 3, 2, 6};
        int k = 3;
        findMaximumOfAllSubArray(inputArray, k);
    }

    // Let's Take an example : 3,2,5,2,1,5
    private static void findMaximumOfAllSubArray(int[] inputArray, int k) {
        Deque<Integer> locationDequeue = new ArrayDeque<>();
        int i = 0;
        // When it reaches to 5, it will remove all lower values because we do not need it.
        for (; i < k; ++i) {
            // If we have found max in current, not need to keep older values in current DeQueue
            while (!locationDequeue.isEmpty() && inputArray[i] >= inputArray[locationDequeue.getLast()])
                locationDequeue.removeLast();

            locationDequeue.addLast(i);
        }
        for (; i < inputArray.length; ++i) {

            System.out.print(inputArray[locationDequeue.getFirst()] + " ");
            // Removing Last Location which is not needed now.
            // Removing which is not coming in current queue.
            while (!locationDequeue.isEmpty() && locationDequeue.getFirst() <= i - k) {
                locationDequeue.removeFirst();
            }
            // Removing all of current is greater than other.
            while (!locationDequeue.isEmpty() && inputArray[i] >= inputArray[locationDequeue.getLast()]) {
                locationDequeue.removeLast();
            }
            locationDequeue.addLast(i);

        }
    }
}
