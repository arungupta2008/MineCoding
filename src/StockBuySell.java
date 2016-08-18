import sun.jvm.hotspot.utilities.Interval;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by arun.gupta on 18/08/16.
 */
public class StockBuySell {


    public static Long stockBuySell(Integer price[], int n)
    {
        if (n == 1)
            return 0L;
        Long profit  = 0L;
        int i = 0;
        while (i < n - 1)
        {
            while ((i < n - 1) && (price[i + 1] <= price[i]))
                i++;
            if (i == n - 1)
                break;
            profit -= price[i++];
        }

        return profit;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int testCount = Integer.parseInt(sc.nextLine());
        int  i = 0;
        while (i< testCount){
            int j = 0;
            int input = Integer.parseInt(sc.nextLine());
            while (j <input ){
                String inputString = sc.nextLine();
                String [] inputValues = inputString.split(" ");
                Integer [] inputNumbers = convertToInt(inputValues);
                System.out.println(stockBuySell(inputNumbers, inputNumbers.length));
                ++j;
            }
            ++i;
        }
//        StockBuySell stock = new StockBuySell();
//
//        int price[] = {1,2,100};
//        int n = price.length;
//
//        stock.stockBuySell(price, n);
    }

    private static Integer[] convertToInt(String[] inputValues) {
        Integer [] response = new Integer[inputValues.length];
        int i = 0;
        for (String in : inputValues){
            response[i] = Integer.parseInt(in);
                    ++i;
        }
        return response;
    }

}