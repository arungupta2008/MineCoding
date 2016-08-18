package AlgorithmProblems.DynamicProgramming;

/**
 * Created by arun.gupta on 16/08/16.
 * 70. Given a Number N and available operation divide by 2, divide by 3 and, subtract by 1. Find minimum Operation required to reach to 1.
 */
public class ReduceTo1 {
    public static void main(String[] args) {
        // We should also able to process these values.
        int n = 123;
        System.out.println(getCount(n));
    }

    private static int getCount(int n) {
        if(n == Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(n == 1){
            return 0;
        }
        if(n < 1){
            return Integer.MAX_VALUE;
        }
        return 1 + MinOf3(getCount(ProcessDvivdeby3(n)), getCount(ProcessDvivdeby2(n)), getCount(n - 1));
    }

    private static int ProcessDvivdeby3(int n) {
        return n % 3 != 0 ? Integer.MAX_VALUE : n / 3;
    }

    private static int ProcessDvivdeby2(int n) {
        return n % 2 != 0 ? Integer.MAX_VALUE : n / 2;
    }


    private static int MinOf3(int one, int two, int three) {
        if (one < two) {
            if (one < three) {
                return one;
            } else {
                return three;
            }
        } else if (two < three) {
            return two;
        } else return three;
    }
}
