package CodingProblem;

/**
 * Created by arun.gupta on 19/05/16.
 */
public class PowerTest {

    /*
    *       Log x / Log y = Log "x" to the base "y"
    *       2^4 = 16
    *       Log 16 to the base 4 = 2
    *       Log 16/ Log 4 = should be Integer if not then not
    *
    * */
    public static boolean isPower(int x, int y) {
        System.out.println(" Math.log(Math.abs(x) : "+Math.log(Math.abs(x)));
        System.out.println(" Math.log(Math.abs(y) : "+Math.log(Math.abs(y)));
        double d = Math.log(Math.abs(x)) / Math.log(Math.abs(y));

        if ((x > 0 && y > 0) || (x < 0 && y < 0)) {
            if (d == (int) d) {
                return true;
            } else {
                return false;
            }
        } else if (x > 0 && y < 0) {
            if ((int) d % 2 == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

//        System.out.println(isPower(-32, -2));
//        System.out.println(isPower(2, 8));
//        System.out.println(isPower(8, 12));
//        System.out.println(isPower(9, 9));
//        System.out.println(isPower(-16, 2));
//        System.out.println(isPower(-8, -2));
//        System.out.println(isPower(16, -2));
//        System.out.println(isPower(8, -2));
        System.out.println(isPower(16, 8));
    }

}
