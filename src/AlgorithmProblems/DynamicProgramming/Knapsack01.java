package AlgorithmProblems.DynamicProgramming;

/**
 * Created by arun.gupta on 04/05/16.
 */

/**
 * 0/1 Knapsack Problem - Given items of certain weights/values and maximum allowed weight
 * how to pick items to pick items from this set to maximize sum of value of items such that
 * sum of weights is less than or equal to maximum allowed weight.
 *
 * Time complexity - O(W*total items)
 *
 * Youtube link
 * Topdown DP - https://youtu.be/149WSzQ4E1g
 * Bottomup DP - https://youtu.be/8LusJS5-AGo
 *
 * References -
 * http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
 * https://en.wikipedia.org/wiki/Knapsack_problem
 */
public class Knapsack01 {

    public static void main(String args[]){
        Knapsack01 k = new Knapsack01();
        int value[] = {22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
        int weight[] = {4, 2, 3, 5, 5, 6, 9, 7, 8, 10};
        // Value and weight Array Size should be same .
        int r = k.bottomUpDP(value, weight, 30);
        System.out.println("Max Sum : "+k.bottomUpDP_Original(value, weight, 30));
//        int r1 = k.topDownRecursive(value, weight, 30);
        System.out.println(r);
//        System.out.println(r1);
    }

    private int getRow(int row){
        return row -1;
    }

    private int bottomUpDP(int[] value, int[] weight, int totalWeight) {
        int matrix[][] = createOuterMatrix(value.length,totalWeight);
        for(int row = 0 ; row<= value.length ; ++row){
            for (int column = 0; column <= totalWeight; ++column){
                if(column == 0 || row == 0){
                    matrix[row][column] = 0;
                    continue;
                }
                if(weight[getRow(row)] > column){
                    matrix[row][column] =matrix[row-1][column];
                }else {
                    matrix[row][column] = Math.max(value[getRow(row)]+ matrix[row-1][column - weight[getRow(row)]], matrix[row-1][column]);
                }
                printMatrix(matrix,value.length+1, totalWeight+1);
            }

        }

        return 0;
    }

    // Original Code
    public int bottomUpDP_Original(int val[], int wt[], int W){
        int K[][] = new int[val.length+1][W+1];
        for(int i=0; i <= val.length; i++){
            for(int j=0; j <= W; j++){
                if(i == 0 || j == 0){
                    K[i][j] = 0;
                    continue;
                }
                if(j - wt[i-1] >= 0){
                    K[i][j] = Math.max(K[i-1][j], K[i-1][j-wt[i-1]] + val[i-1]);
                }else{
                    K[i][j] = K[i-1][j];
                }
            }
        }
        return K[val.length][W];
    }

    private void printMatrix(int[][] matrix, int i, int j) {
        for(int row = 0 ; row< i ; ++row){
            for (int column = 0; column < j; ++column){
                System.out.print(matrix[row][column]+"\t");
            }
            System.out.println();
        }

        System.out.println("\n\n\n");
    }

    private int[][] createOuterMatrix(int row, int column) {
        return new int[row+1][column+1];
    }

}
