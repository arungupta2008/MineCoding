package AlgorithmProblems.DynamicProgramming;

/**
 * Created by arun.gupta on 17/08/16.
 * https://www.careercup.com/question?id=5699124738392064
 * Given an array of numbers, find the maximum and minimum sum of sub sequences at a distance > m
 * <p>
 * Example –
 * <p>
 * arr = {3, 4, -2, 1, -2, 4, 6, -3, 5} & m = 2
 * <p>
 * Solution – max = 13 {4 + 4 + 5}, min = -5 {-2-3}
 */
public class SubSequence {
    public enum type {
        MAX, MIN
    }

    public static void main(String[] args) {
//        int[] arr = {-9, -9, 9, 4, 4, -2, 1, -2, 4, 6, -3, 5, 7, -2, -3};
        int[] arr = {3, 4, -2, 1, -2, 4, 6, -3, 5};
        int m = 2;
        System.out.println("Max :" + findSubSequence(m, arr, type.MAX));
        System.out.println("Min :" + findSubSequence(m, arr, type.MIN));
    }

    private static int findSubSequence(int m, int[] arr, type type) {
        int calculatedValue;
        if (type == type.MAX) {
            calculatedValue = Integer.MIN_VALUE;
        } else {
            calculatedValue = Integer.MAX_VALUE;
        }

        for (int i = 0; i < arr.length; ++i) {
            if (type == type.MAX) {
                calculatedValue = Math.max(subSequence(m + 1, arr, i, type.MAX), calculatedValue);
            } else {
                calculatedValue = Math.min(subSequence(m + 1, arr, i, type.MIN), calculatedValue);
            }
        }
        return calculatedValue;
    }

    private static int subSequence(int m, int[] arr, int index, type type) {
        int calculatedValue;
        if (type == type.MAX) {
            calculatedValue = Integer.MIN_VALUE;
        } else {
            calculatedValue = Integer.MAX_VALUE;
        }
        if (index > (arr.length - 1)) {
            return 0;
        }
        if ((type == type.MAX && arr[index] < 0) || (arr[index] > 0 && type == type.MIN) )
            return 0;
        int tmp = index;
        for (; index < tmp + m + m; ++index) {
            if (type == type.MAX) {
                calculatedValue = Math.max(subSequence(m, arr, index + m, type), calculatedValue);
            }else {
                calculatedValue = Math.min(subSequence(m, arr, index + m, type), calculatedValue);
            }
        }
        return calculatedValue + arr[tmp];
    }
}
