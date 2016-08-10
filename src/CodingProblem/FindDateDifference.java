package CodingProblem;

/**
 * Created by arun.gupta on 02/08/16.
 * Find how many days you have between two given dates
 * TODO
 */
public class FindDateDifference {

    public static void main(String[] args) {
        String date1 = "12-12-2016";
        String date2 = "12-12-2114";
        System.out.println(findDaysDiff(date1,date2));
    }

    private static boolean findDaysDiff(String date1, String date2) {
        String[] date1String = date1.split("-");
        String[] date2String = date2.split("-");

        int yearDiff = Math.abs(Integer.valueOf(date1String[2]) -Integer.valueOf(date2String[2]));
        return false;
    }
}
