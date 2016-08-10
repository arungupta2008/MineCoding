package CodingProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Created by arun.gupta on 09/08/16.
 * Booking.com
 * <p>
 * <p>
 * Two strings are given, each representing one or more words. There are no punctuation characters in these strings. Words are separated by single whitespace character. The task is to write a function which tests whether these strings are anagrams. Two strings are anagrams if they are not equal, but use exactly the same rearranged set of letters. Letter casing and blank space characters should be ignored. Function should return value true if two strings are anagrams and value false otherwise.
 * Examples: Words "license" and "silence" are anagrams and function should return true. "William Shakespeare" is anagram with "I am a weakish speller".
 */
public class MergeAnagrams {
    static HashMap<Character, Integer> charMap;

    public static void main(String[] args) {
        initCharMap();
        String arr = "cat dog tac god act abc def bca ijh hji klm nmo poq qop jih mlk";
        String[] words = arr.split(" ");
        int[] prod = new int[words.length];
        String[] calculatedWords = new String[words.length];

        System.out.println(Arrays.toString(words));

        for (int i = 0; i < words.length; i++)
            prod[i] = calculateProd(words[i]);

        System.out.println(Arrays.toString(prod));
        LinkedHashMap<Integer, Integer> counts = new LinkedHashMap<Integer, Integer>();
        for (Integer a : prod) {
            int count = 0;
            if (counts.containsKey(a)) {
                count = counts.get(a) + 1;
            }
            counts.put(a, count);
        }

        LinkedHashMap<Integer, Integer> startPos = new LinkedHashMap<Integer, Integer>();

        int currentPos = 0;
        Iterator<Integer> it = counts.keySet().iterator();
        while (it.hasNext()) {
            int key = it.next();
            startPos.put(key, currentPos);
            currentPos += (counts.get(key) + 1);
        }
        for (int i = 0; i < words.length; i++) {
            int pos = startPos.get(prod[i]);
            calculatedWords[pos] = words[i];
            startPos.put(prod[i], ++pos);
        }
        System.out.println(Arrays.toString(calculatedWords));
    }

    private static int calculateProd(String word) {
        char[] arr = word.toCharArray();
        int sum = 1;
        for (char c : arr)
            sum *= charMap.get(c);
        return sum;
    }

    private static void initCharMap() {
        charMap = new HashMap<Character, Integer>();
        charMap.put('a', 2);
        charMap.put('b', 3);
        charMap.put('c', 5);
        charMap.put('d', 7);
        charMap.put('e', 11);
        charMap.put('f', 13);
        charMap.put('g', 17);
        charMap.put('h', 23);
        charMap.put('i', 29);
        charMap.put('j', 31);
        charMap.put('k', 37);
        charMap.put('l', 41);
        charMap.put('m', 43);
        charMap.put('n', 53);
        charMap.put('o', 59);
        charMap.put('p', 61);
        charMap.put('q', 67);
        charMap.put('r', 71);
        charMap.put('s', 73);
        charMap.put('t', 79);
        charMap.put('u', 83);
        charMap.put('v', 89);
        charMap.put('w', 97);
        charMap.put('x', 101);
        charMap.put('y', 103);
        charMap.put('z', 107);
    }
}