package AlgorithmProblems.DynamicProgramming;

import Helper.MatrixHelper;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by arun.gupta on 19/07/16.
 * <p>
 * Given a N biased coin with probability coming as HAED, Find Probability of selecting exact K<=n coins commming as
 * Heads
 */
public class BiasedCoinKProbability {
    public static void main(String[] args) {
//        Double[] probability = {0.5, .4, .6, .7, .2, .1};
//        int k = 3;
//        System.out.println("Probability is :  " + findProbabilityOfExactKHeads(probability, k));
//
//        Double[] probability1 = {0.5, .4};
//        int k1 = 2;
//        System.out.println("Probability is :  " + findProbabilityOfExactKHeads(probability1, k1));
//
//        Double[] probability2 = {0.5 ,0.65, .45, .15, .5};
//        int k2 = 3;
//        System.out.println("Probability is :  " + findProbabilityOfExactKHeads(probability2, k2));
//
//        Double[] probability3 = {0.5, .5, .5};
//        int k3 = 2;
//        System.out.println("Probability is :  " + findProbabilityOfExactKHeads(probability3, k3));
//
//        Double[] probability4 = {0.5, .3, .2};
//        int k4 = 2;
//        System.out.println("Probability is :  " + findProbabilityOfExactKHeads(probability4, k4));

        Double[] probability5 = {0.5, .3, .2, .15, .45};
        int k5 = 3;
        System.out.println("Probability is :  " + findProbabilityOfExactKHeads(probability5, k5));


    }

    private static Double findProbabilityOfExactKHeads(Double[] probability, int k) {

        DecimalFormat df = new DecimalFormat("#.#####");
        df.setRoundingMode(RoundingMode.CEILING);

        Double[][] costMatrix = new Double[k + 1][probability.length + 1];

        MatrixHelper.FillMatrix(costMatrix, 0.0, k + 1, probability.length + 1);
        // Selecting 0 coins with Zero Heads is 1
        costMatrix[0][0] = 1.0;

        /*
        * Special Case Where calculating P(0,1), P(0,2), P(0,3) where selecting 0 Heads in i coins
        * */
        for (int j = 1; j <= probability.length; ++j) {
            costMatrix[0][j] = Double.valueOf(df.format(costMatrix[0][j - 1] * probability[j - 1]));
        }
        MatrixHelper.PrintMatrix(costMatrix, k + 1, probability.length + 1);
        for (int i = 1; i <= k; ++i) {
            for (int j = 1; j <= probability.length; ++j) {

                // Case when P(i,j) == where it says Probability of selecting i Heads in j coins where i can not be
                // less than j. For Ex. 3(i) heads can not come in 2 coins.
                if (i > j) {
                    continue;
                }
                // Case Where Selecting P(i,j) : where selecting i coins out of j coins and i  = j means :
                // Calculating Probability of coming 3 HEAD of of 3 Coins which will be P(0,0)*P(1,1)*P(2,2)*P(3,3)
                // Note Here P(0,0) =1
                if (i == j) {
                    costMatrix[i][j] = Double.valueOf(df.format(costMatrix[i - 1][j - 1] * probability[j - 1]));
                } else if (i < j) {
                    // Recurrence Relation : P(i,j) = Probability of Getting i heads without including j the Coin +
                    //  Probability of Getting i heads including jthe Coin
                    //P(3,4) = P(3,3) (1-P[4]) + P(2,3) (P[4]);
                    // Here i = coins with i heads
                    // Here j = first J coins out of N coins.
                    costMatrix[i][j] = Double.valueOf(df.format(costMatrix[i][j - 1] * (1 - probability[j - 1]) +
                            costMatrix[i - 1][j -
                                    1] * probability[j - 1]));
                }
                MatrixHelper.PrintMatrix(costMatrix, k + 1, probability.length + 1);
            }

        }
        return costMatrix[k][probability.length];
    }
}
