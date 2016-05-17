package AlgorithmProblems.DynamicProgramming;

/**
 * Created by arun.gupta on 06/05/16.
 * 	18. Maximum Sum non adjacent Element : A is the Array Given. Take two values exclusive and inclusive.
 A. Exclusive says at point I what is the max value it can have with excluding A[i].
 B. Inclusive says what is the max sum it can have after including A[i]
 C. Formula at any point in Array Inclusive  = MAX(Exclusive + A[i], Inclusive)
 D. Exclusive = Inclusive.



 */
public class MaxSumForNonAdjacentElements {

    public static void main(String args[]) {
        MaxSumForNonAdjacentElements msn = new MaxSumForNonAdjacentElements();
        int arr[] = { 2, 10, 13, 4, 2, 15, 10 };
        System.out.println(msn.maxSum(arr));

    }

    private int maxSum(int[] arr) {
        int inclusive =0;
                int exclusive = 0;
        for(int i = 0; i < arr.length; i++){
            int temIn = inclusive;
            inclusive = Math.max(inclusive,exclusive+arr[i]);
            exclusive = temIn;

            System.out.println("inclusive : "+inclusive);
            System.out.println("Exclusive : "+exclusive);
            System.out.println();
        }
        return Math.max(inclusive,exclusive);
    }

}
