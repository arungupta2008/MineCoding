package CodingProblem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by arun.gupta on 30/07/16.
 *
 * Optiver
 */
public class CalenderSorting {

    /*
 * Complete the function below.
 */

    public static Date ThirdLatest(Date[] dates) throws Exception{
        Set<java.util.Date> dateList = new TreeSet<>();
        SimpleDateFormat requiredFormat = new SimpleDateFormat("dd-MM-yyyy");

        for(Date date : dates) {
            String dateString = date.Day + "-" + date.Month + "-" + date.Year;
            dateList.add(getDateObjectFromStringWithFormat(dateString, requiredFormat));
        }

        List<java.util.Date> newList = new ArrayList<java.util.Date>(dateList);
        Collections.sort(newList);
        int requiredPosition = 3;
        java.util.Date finalDate = newList.get(newList.size() - requiredPosition);

//    String finalDateString = getStringFromDate(finalDate, requiredFormat);


        Calendar cal = Calendar.getInstance();
        cal.setTime(finalDate);

        Date resultDate = new Date();
        resultDate.Day = cal.get(Calendar.DAY_OF_MONTH);
        resultDate.Month = cal.get(Calendar.MONTH) + 1;
        resultDate.Year = cal.get(Calendar.YEAR);
        return resultDate;
    }

    public static java.util.Date getDateObjectFromStringWithFormat(String dateString, SimpleDateFormat format) throws ParseException {
        java.util.Date date = format.parse(dateString);
        return date;
    }

    public static String getStringFromDate(Date date, SimpleDateFormat formatter) {
        return formatter.format(date);
    }

}
