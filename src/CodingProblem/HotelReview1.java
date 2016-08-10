package CodingProblem;

/**
 * Created by arun.gupta on 09/08/16.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by ankit.rai on 02/08/16.
 * Booking.com
 *
 *
 *
 breakfast beach citycenter location metro view staff price
 5
 1
 This hotel has a nice view of the citycenter. The location is perfect.
 2
 The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.
 1
 Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.
 1
 They said I couldn't take my dog and there were other guests with dogs! That is not fair.
 2
 Very friendly staff and good cost-benefit ratio. Location is a bit far from citycenter.
 */
public class HotelReview1 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String inputWords = stdin.readLine();
        Set<String> targetReviewWords = new HashSet<>();

        String [] singleReviewWords = inputWords.split(" ");

        for(String s: singleReviewWords) {
            targetReviewWords.add(s);
        }

        final SortedMap<Integer, Integer> hotelToCountMap = new TreeMap<>();
        int n = Integer.parseInt(stdin.readLine());
        for(int i = 0 ; i < n ; i++) {
            int hotelId = Integer.parseInt(stdin.readLine());
            String hotelIdReview = stdin.readLine();
            String [] individualReviews = hotelIdReview.split(" ");
            if(!hotelToCountMap.containsKey(hotelId)) {
                hotelToCountMap.put(hotelId, 0);
            }
            for(String hotelReviews: individualReviews) {
                hotelReviews.replaceAll(".", "");
                hotelReviews.replaceAll(",", "");
                hotelReviews.replaceAll(";", "");
                hotelReviews.replaceAll(":", "");
                hotelReviews.replaceAll("!", "");
                if(targetReviewWords.contains(hotelReviews)) {
                    hotelToCountMap.put(hotelId, hotelToCountMap.get(hotelId) + 1);
                }
            }
        }
        SortedMap<Integer, Integer> finalCountMap = new TreeMap<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer)hotelToCountMap.get(o2).compareTo((Integer) hotelToCountMap.get(o1));
            }
        });

        for (Map.Entry<Integer, Integer> entry : hotelToCountMap.entrySet())
        {
            finalCountMap.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<Integer, Integer> entry : finalCountMap.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(" ");
        }
    }
}


