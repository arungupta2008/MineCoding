package CodingProblem;

/**
 * Created by arun.gupta on 03/08/16.
 *
 * 	54. [Coding-Interview] A company uses a format to exchange messages with us. You need to validate the input.
 The character encoding ASCII. Valid characters are between 0x20 (space) and 0x7E (~).
 write validate function to generate valid output or the error message.  



 3
 down vote
 If you do this:

 int value1 = 0x2FE;
 int value2 = new Scanner("2FE").nextInt(16);
 Both value1 and value2 will be integer 766 in base 10.

 */
public class ASCIIValidation {
    public static void main(String[] args) {
        int startASCIIInput = 0x20;
        int endASCIIInput = 0x7E;
        String validationInput = "^%&^%&SFfref $434t34";
        validateInputforASCII(startASCIIInput, endASCIIInput, validationInput);
    }

    private static void validateInputforASCII(int startASCIIInput, int endASCIIInput, String validationInput) {
        char [] inputChar = validationInput.toCharArray();
        for (char charInput : inputChar){
            if(startASCIIInput > charInput || endASCIIInput < charInput){
                System.out.println(charInput+" Invalid Input");
            }else
                System.out.println(charInput+" Valid Input");
        }
    }
}
