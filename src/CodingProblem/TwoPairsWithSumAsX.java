package CodingProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by arun.gupta on 09/08/16.
 */
public class TwoPairsWithSumAsX {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int [] arr = new int[M];
        for (int i = 0; i<M; ++i){
            arr[i] = sc.nextInt();
        }
        System.out.println(isExist(arr, N) ? 1 :0);

    }
    public static boolean isExist(int [] arr, int x) {
        Map<Integer, Integer> sumMap = new HashMap<>();

        for(int i = 0 ; i < arr.length; i++) {
            if(sumMap.containsKey(x-arr[i])) {
                return true;
            }
            sumMap.put(arr[i], arr[i]);
        }

        return false;
    }
}
