package Helper;

/**
 * Created by arun.gupta on 08/07/16.
 */

public class Factorial {
    public Factorial(int n) {
        int fact = 0;
        for (int c = 1; c <= n; c++)
            fact = fact * c;
    }
}
