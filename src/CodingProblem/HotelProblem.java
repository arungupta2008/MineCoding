package CodingProblem;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by arun.gupta on 02/08/16.
 * Booking.com
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * breakfast beach citycenter location metro view staff price
 * 5
 * 1
 * This hotel has a nice view of the citycenter. The location is perfect.
 * 2
 * The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.
 * 1
 * Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.
 * 1
 * They said I couldn't take my dog and there were other guests with dogs! That is not fair.
 * 2
 * Very friendly staff and good cost-benefit ratio. Location is a bit far from citycenter.
 */
public class HotelProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputKeyWords = scanner.nextLine().split(" ");
        Integer reviewSize = Integer.valueOf(scanner.nextLine());
        HashMap<Integer, List<String>> inputOfReviews = new HashMap<>();
        for (int i = 0; i < reviewSize; ++i) {
            int hotelId = Integer.valueOf(scanner.nextLine());
            String review = scanner.nextLine().toLowerCase();
            review.replaceAll(".", "");
            review.replaceAll(",", "");
            review.replaceAll(";", "");
            review.replaceAll(":", "");
            review.replaceAll("!", "");
            List<String> reviewList = inputOfReviews.get(hotelId);
            if (reviewList == null) {
                reviewList = new ArrayList<>();
            }
            reviewList.add(review);
            inputOfReviews.put(hotelId, reviewList);
        }
        TreeMap<Integer, Integer> output = new TreeMap<>();
        for (Map.Entry<Integer, List<String>> entry : inputOfReviews.entrySet()) {
            Integer hotelId = entry.getKey();
            int count = 0;
            for (String review : entry.getValue()) {
                for (String keyWord : inputKeyWords) {
                    count += countWord(review, keyWord);
                }
            }
            output.put(hotelId,count);
        }

        SortedMap<Integer, Integer> newCountMap = new TreeMap<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer)output.get(o2).compareTo((Integer) output.get(o1));
            }
        });

        for (Map.Entry<Integer, Integer> entry : output.entrySet())
        {
            newCountMap.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<Integer, Integer> entry : newCountMap.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(" ");
        }
    }

    public static int countWord(String sentence, String word) {
        int count = 0;
        Pattern p = Pattern.compile(word);
        Matcher m = p.matcher(sentence);
        while (m.find()) {
            count++;
        }
        return count;
    }

}
