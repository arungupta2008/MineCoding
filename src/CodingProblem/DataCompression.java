package CodingProblem;

import java.beans.Expression;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by arun.gupta on 10/07/16.
 * <p>
 * <p>
 * <p>
 * There is a compressed string eg. ”ab2c3”, the string has lowercase characters and numbers. We can uncompress the given string as follows: whenever we get a number “n” in the string, the portion of the string before the number will repeat “n” times. So in the above example, we get a 2, so string will become “ababc3”, now we get a 3, so final string will be “ababcababcababc”.
 * Given a compressed string and a number k, you have to output the k’th character in the uncompressed string.
 * <p>
 * 1 <= length of string <= 1500
 * 1 <= n <= 1000
 * 1 <= k < 2^31
 * example:
 * input: ab2c3 10
 * output: c
 * <p>
 * <p>
 * <p>
 * CalenderSorting :
 * <p>
 * ab2c3 10
 * ((2*2)+1)*3 > 10
 * So it is somewhere in the (2*2)+1 chunk. 10%5 = 0 (or 5) = 5
 * Ignoring the info in the 4 chunk, we take the 5th. So the answer is c.
 * <p>
 * A more complex example:
 * ab10c9de5 53
 * ((2*10) + 1) *9 > 53
 * Consider [(2*10) + 1] chunk. It will be the 53 % 21 = 11th
 * (2*10) > 11
 * Consider the [2] chunk. It will be the 11%2 = 1st character
 * = a
 * <p>
 * Example:
 * <p>
 * One done by me :
 * ab13cd13d12    196
 * <p>
 * ((2*13) + 2)*13 > 196
 * <p>
 * 336 % 196 == 140%28 == 0 which is last of ab13cd12 = which is C so ans is C
 * <p>
 * 364 > 196
 * 53 % (13*2) + 2 = 25
 */

class Node {
    public List<Character> characterList = new ArrayList<>();
    public int number = 0;
    public int currentSum = 0;

    public Node(int finalLength) {
        currentSum = finalLength;
    }
}

public class DataCompression {
    public static void main(String[] args) {
        //String input = "ab10c9de5~";
        //int n = 53;

//        String input = "ab2c3~";
//        int n =10;

//        String input = "ab13cd13d12~";
//        int n = 103;

        String input = "ab2cd2d2ef4gh4ij2k2lmnop5~";
        int n = 190;

        System.out.println("No Character Found :"+getChar(input,n));
    }

    private static String getChar(String input, int n) {
        char[] charArray = input.toCharArray();
        List<Character> outputChar = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();
        int currentLength = 0;
        int currentStringLength = 0;
        int currentNumber = 0;
        int finalLength = 0;
        boolean flag = false;
        for (char inputChar : charArray) {
            if (inputChar >= 65) {
                if (flag == true) {
                    Node node = new Node(finalLength);
                    node.characterList = outputChar;
                    node.number = currentNumber;
                    nodeStack.push(node);
                    outputChar = new ArrayList<>();
                    currentLength = (currentLength + currentStringLength) * currentNumber;
                    finalLength = currentLength;
                    flag = false;
                    currentStringLength = 0;
                    currentNumber = 0;
                    if (currentLength > n) {
                        getTheFinalChar(nodeStack, n);
                    }
                }
                outputChar.add(inputChar);
                ++currentStringLength;
            } else {
                flag = true;
                if (currentNumber == 0) {
                    currentNumber = inputChar - '0';
                } else {
                    currentNumber = getNumber(currentNumber, inputChar - '0');
                }
            }
        }
        return null;
    }

    private static void getTheFinalChar(Stack<Node> nodeStack, int n) {
        while (!nodeStack.isEmpty()) {
            Node node = nodeStack.pop();

            if (getValue(node) > n) {
                if (nodeStack.isEmpty()) {
                    int val = n % node.characterList.size();
                    if (val == 0) {
                        System.out.println("Print : " + node.characterList.get(node.characterList.size() - 1));
                        System.exit(0);
                    }
                    System.out.println("Print : " + node.characterList.get(val - 1));
                    System.exit(0);
                } else {
                    n = n % (node.currentSum + node.characterList.size());
                    if (n == 0) {
                        System.out.println("Print : " + node.characterList.get(node.characterList.size() - 1));
                        System.exit(0);
                    }
                    if (n > node.currentSum) {
                        n = n % node.currentSum;
                        System.out.println("Print : " + node.characterList.get(node.characterList.size() - 1));
                        System.exit(0);
                    }
                    getTheFinalChar(nodeStack, n);
                }
            } else {
                int val = n % node.characterList.size();
                System.out.println("Print : " + node.characterList.get(val - 1));
                System.exit(0);
            }
        }
    }

    private static int getValue(Node node) {
        System.out.println("Val : " + ((node.currentSum + node.characterList.size()) * node.number));
        return ((node.currentSum + node.characterList.size()) * node.number);
    }

    private static int getNumber(int currentNumber, Integer suffixInteger) {
        return currentNumber * 10 + suffixInteger;
    }
}
