package CodingProblem;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by arun.gupta on 17/05/16.
 * http://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
 */
public class Parentheses {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print(" Enter value :  ");
        String parenthesesInput = scanner.next();

        System.out.println("Valid "+ validateParantheses(parenthesesInput));
    }

    private static boolean validateParantheses(String parenthesesInput) {
        Stack<Character> characterStack = new Stack<>();
        //char [] parenthesesInputCharArray = parenthesesInput.toCharArray();
        for(char charInput : parenthesesInput.toCharArray()){
            if(validChar(charInput)) {
                if(characterStack.size() > 0 && isValidClosure(characterStack.peek(), charInput)){
                    characterStack.pop();
                }else {
                    characterStack.push(charInput);
                }

            }
            System.out.println("characterStack : "+ characterStack.toString());
        }
        if(characterStack.size() == 0){
            return true;
        }
        return false;
    }

    private static boolean isValidClosure(Character peek, char charInput) {
        if((peek == '(' && charInput == ')') || (peek == '{' && charInput == '}') || (peek == '[' && charInput == ']'))
            return true;
        return false;
    }

    private static boolean validChar(char charInput) {
        if(charInput == '[' || charInput == ']' || charInput == '{' || charInput == '}' || charInput == '(' || charInput == ')')
            return true;
        return false;
    }
}
