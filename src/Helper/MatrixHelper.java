package Helper;

/**
 * Created by arun.gupta on 05/07/16.
 */
public class MatrixHelper {
    public static void PrintMatrix(final Integer[][] matrix, int i, int j) {
        System.out.print("\n");
        for (int l = 0; l < i; ++l) {
            for (int k = 0; k < j; ++k) {
                System.out.printf("%12d", matrix[l][k]);
            }
            System.out.print("\n");
        }
    }

    public static void FillMatrix(Object[][] costMatrix, Object maxValue, int i, int j) {
        for (int l = 0; l < i; ++l) {
            for (int m = 0; m < j; ++m) {
                costMatrix[l][m] = maxValue;
            }
        }
    }
}
