package CodingProblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by arun.gupta on 04/08/16.
 *
 * Atlassian
 *
 * Function Should Return : LookAndSay(1) == 11   if you Read you will Read one 1 so 11
 * LookAndSay(122) = 1122 because if you read you will read it as one 1 and two 2  .
 */
public class LookAndSay {

    private static String LookAndSay(String number, int s) {
        for (int i = 0; i < s; i++) {
            number = LookAndSayOneTime(number);
        }
        return number;
    }

    private static String LookAndSayOneTime(String inputString) {
        StringBuilder outputString = new StringBuilder();

        char repeat = inputString.charAt(0);
        inputString = inputString.substring(1) + " ";
        int count = 1;

        for (char actual : inputString.toCharArray()) {
            if (actual != repeat) {
                outputString.append(count).append("").append(repeat);
                count = 1;
                repeat = actual;
            } else {
                count += 1;
            }
        }
        return outputString.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
//        final String fileName = System.getenv("OUTPUT_PATH");
//        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        String _start;
        try {
            _start = in.nextLine();
        } catch (Exception e) {
            _start = null;
        }

        int _n;
        _n = Integer.parseInt(in.nextLine());

        System.out.println(LookAndSay(_start, _n));
//        bw.write(res);
//        bw.newLine();
//
//        bw.close();
    }


}
