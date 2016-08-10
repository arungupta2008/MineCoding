package CodingProblem;

import java.util.Stack;

/**
 * Created by arun.gupta on 02/08/16.
 *
 * Complete the function that takes an integer as its argument and returns the encoded string in base 7 using the following encoding rule:
 base 10 ::::    0     1    2    3    4    5    6
 base 7   ::::   0     a    t    l    s    i    N

 Sample Input 1
 7

 Sample Output 1
 a0  


 atlassian Coding Round
 */
public class BaseConversion {
    public static void main(String[] args) {
        Long value = 54654645L;

        System.out.println(getTheValues(value));
    }

    private static String getTheValues(Long number) {
        Integer toBase = 7;
        char [] toBaseMapping = {'0','a', 't', 'l', 's', 'i', 'n'};
        Stack<Integer> stack = new Stack<>();
        while (number>=toBase){
            Long divident = number/toBase;
            Integer modulo = (int)(number % toBase.longValue());
            number = divident;
            if(divident>= 1){
                stack.push(modulo);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(toBaseMapping[number.intValue()]);
        while (!stack.empty()){
            stringBuilder.append(toBaseMapping[stack.pop()]);
        }
        return stringBuilder.toString();
    }
}
