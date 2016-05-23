package CodingProblem;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by arun.gupta on 17/05/16.
 * <p>
 * http://www.informatik.uni-ulm.de/acm/Locals/2003/html/histogram.html
 */
public class MaximumHistogramArea {

    public static void main(String[] args) {
        int[] input1 = {7, 2, 5, 3, 1, 4, 4, 5, 1};
        System.out.println(String.format("Input : %s  Area : %d", Arrays.toString(input1), findMaxHistogramAream(input1)));

        int[] input2 = {7, 4, 5, 3, 1, 4, 4, 5, 1};
        System.out.println(String.format("Input : %s  Area : %d", Arrays.toString(input2), findMaxHistogramAream(input2)));

        int[] input3 = {7, 4, 5, 4, 1, 4, 4, 5, 1};
        System.out.println(String.format("Input : %s  Area : %d", Arrays.toString(input3), findMaxHistogramAream(input3)));
    }

    private static Integer findMaxHistogramAream(int[] input1) {
        Stack<Integer> areaStack = new Stack<Integer>();
        areaStack.push(0);
        int i = 1;
        int top = 0;
        int maxArea = -1;
        return getMaxHistogramArea(areaStack, i, top, maxArea, input1);
    }

    private static Integer getMaxHistogramArea(Stack<Integer> areaStack, int i, int top, int maxArea, int[] inputArray) {
        for (; i <= inputArray.length; ++i) {
            int area = 0;
            if (inputArray.length == i) {
                if (areaStack.size() > 0) {
                    top = areaStack.pop();
                    area = inputArray[top] * i;
                    maxArea = putArea(area, maxArea);
                    break;
                }
            }
            if (inputArray[i] < inputArray[i - 1]) {
                top = areaStack.pop();
                if (areaStack.size() == 0) {
                    area = inputArray[top] * i;
                    maxArea = putArea(area, maxArea);
                } else {
                    while (inputArray[i] < inputArray[top]) {
                        if (areaStack.size() == 0) {
                            area = inputArray[top] * i;
                            maxArea = putArea(area, maxArea);
                            break;
                        } else {
                            area = inputArray[top] * (i - areaStack.peek() - 1);
                            maxArea = putArea(area, maxArea);
                        }
                        if (inputArray[areaStack.peek()] > inputArray[i]) {
                            top = areaStack.pop();
                        } else {
                            break;
                        }
                    }
                }
            }
            areaStack.push(i);
        }
        return maxArea;
    }

    private static int putArea(int area, int maxArea) {
        return area < maxArea ? maxArea : area;
    }
}
