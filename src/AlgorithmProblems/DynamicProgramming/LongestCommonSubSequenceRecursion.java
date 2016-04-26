package AlgorithmProblems.DynamicProgramming;

/**
 * Created by arun.gupta on 23/04/16.
 */
public class LongestCommonSubSequenceRecursion {

    static int a = 1;
    public static int LCS(String A, String B) {
        System.out.println("a : "+a++);
        if (A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int lenA = A.length();
        int lenB = B.length();
        // check if last characters are same
        if (A.charAt(lenA - 1) == B.charAt(lenB - 1)) {
            // Add 1 to the result and remove the last character from both
            // the strings and make recursive call to the modified strings.
            return 1 + LCS(A.substring(0, lenA - 1), B.substring(0, lenB - 1));
        } else {
            // Remove the last character of String 1 and make a recursive
            // call and remove the last character from String 2 and make a
            // recursive and then return the max from returns of both recursive
            // calls
            return Math.max(
                    LCS(A.substring(0, lenA - 1), B.substring(0, lenB)),
                    LCS(A.substring(0, lenA), B.substring(0, lenB - 1)));
        }
    }

    public static void main(String[] args) {
        String A = "ACBDEA";
        String B = "ABCDA";
        System.out.println("A : "+A.toString()+ " B : "+B.toString());
        System.out.println("LCS :" + LCS(A, B));
    }
}
