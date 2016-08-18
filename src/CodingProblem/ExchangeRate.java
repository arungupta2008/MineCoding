package CodingProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by arun.gupta on 12/08/16.
 */
public class ExchangeRate {

    public double getRate(String from, String to, int amount) {
        try {
            URL url = new URL("http://finance.yahoo.com/d/quotes.csv?f=l1&s="+ from + to + "=X");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();
            if (line.length() > 0) {
                return Double.parseDouble(line) * amount;
            }
            reader.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public static void main(String args[]) {

        ExchangeRate exchange = new ExchangeRate();

        // converting 1000 Euro to US Dollar
        System.out.println("1000 Euro/US Dollar: " + exchange.getRate("EUR", "USD", 1000));

        // converting 1000 US Dollar to Euro
        System.out.println("1000 US Dollar/Euro: " + exchange.getRate("USD", "EUR", 1000));

        // converting 1000 US Dollar to Indian Rupee
        System.out.println("1000 US Dollar/Indian Rupee: " + exchange.getRate("USD", "INR", 1000));

        // converting 1000 Indian Rupee to US Dollar
        System.out.println("1000 Indian Rupee/US Dollar: " + exchange.getRate("INR", "USD", 1000));
    }
}
