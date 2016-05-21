package CodingProblem;

import java.util.Arrays;

/**
 * Created by arun.gupta on 21/05/16.
 * Mancar's Algorithm
 */
public class LongestPalindromincSubString {

    public static void main(String[] args) {
        String inputString = "abaxabaxabybaxabyb";
        printLongestPalindrome(inputString);
        inputString = "abaab";
        printLongestPalindrome(inputString);

        inputString = "aabyybaabbyyyyyyyyyyyyyyyyyybbbbaaababababab";
        printLongestPalindrome(inputString);

    }

    private static void printLongestPalindrome(String inputString) {
        inputString = inputString.replace("","#").trim();
        int[] auxArray = new int[inputString.length()];
        int Loc = 1;
        int currentPalindromCenterLocation = 0;
        auxArray[0] = 1;

        calculateMaxPalindromSubString(inputString.toCharArray(), auxArray, Loc, currentPalindromCenterLocation);
        System.out.println("\n\nArray : " + Arrays.toString(auxArray));
        printLongestPalindrom(auxArray, inputString.toCharArray());
    }

    private static void printLongestPalindrom(int[] auxArray, char[] inputString) {
        int maxPalindromeSize = -1;
        int maxPalindromeRootLocation = 0;
        for(int i = 0; i< auxArray.length; ++i){
            if(maxPalindromeSize < auxArray[i]){
                maxPalindromeSize = auxArray[i];
                maxPalindromeRootLocation = i;
            }
        }
        int leftEdge = getPalindromeLeftEdgeLocation(maxPalindromeSize,maxPalindromeRootLocation);
        int rightEdge = getPalindromeRightEdgeLocation(maxPalindromeSize,maxPalindromeRootLocation);
        System.out.println("\n");
        for(int i = leftEdge; i <=rightEdge; ++i){
            if('#' != inputString[i])
                System.out.print(inputString[i]);
        }
        System.out.println("\n");
    }

    private static void calculateMaxPalindromSubString(final char[] inputString, int[] palindromLenghtArray, int currentLocation, int currentPalindromCenterLocation) {
        for (; currentLocation < inputString.length; ++currentLocation) {
            int rightWing = getPalindromeRightEdgeLocation(palindromLenghtArray[currentPalindromCenterLocation], currentPalindromCenterLocation);
            if (!IfCurrentLocationUnderTheCurrentPalindrome(rightWing, currentLocation)) {
                palindromLenghtArray[currentLocation] = getPalindromeLength(currentLocation, inputString);
                currentPalindromCenterLocation = currentLocation;
                if (IfWeReachedTillEnd(palindromLenghtArray[currentPalindromCenterLocation], currentPalindromCenterLocation, inputString.length)) {
                    System.out.println("Array : " + Arrays.toString(palindromLenghtArray));
                    break;
                }
            } else {
                int mirrorPalindromeLength = canWeTakeMirrorPalindromeLength(currentLocation, currentPalindromCenterLocation, palindromLenghtArray);
                if (mirrorPalindromeLength > 0) {
                    int currentLocationPalindromeLength = getPalindromeLength(currentLocation, inputString, mirrorPalindromeLength);
                    palindromLenghtArray[currentLocation] = currentLocationPalindromeLength;
                    //boolean isNewRoot = isItANewRoot(currentLocation, currentPalindromCenterLocation, palindromLenghtArray);
                    currentPalindromCenterLocation = currentLocation;
                    if (IfWeReachedTillEnd(palindromLenghtArray[currentPalindromCenterLocation], currentPalindromCenterLocation, inputString.length)) {
                        System.out.println("Array : " + Arrays.toString(palindromLenghtArray));
                        break;
                    }
                }
//                int currentLocationPalindromLenght = getPalindromeLength(currentLocation,inputString,
//                        currentLocationPalindromeLeastSize(currentLocation,currentPalindromCenterLocation,palindromLenghtArray));
//
//                boolean isCurrentLocationPalindromeLengthSameAsMirror = isCurrentLocationPalindromeLengthSameAsMirror(currentLocation,currentPalindromCenterLocation, currentLocationPalindromLenght,palindromLenghtArray);
////                if(canWeChooseCurrentLocationAsNewRoot(currentLocation, currentPalindromCenterLocation, palindromLenghtArray,inputString)){
////
////                }
            }
            System.out.println("Array : " + Arrays.toString(palindromLenghtArray));
        }
    }

    private static boolean IfWeReachedTillEnd(int palindromeSize, int currentPalindromCenterLocation, int arrayLength) {
        int rightEdge = getPalindromeRightEdgeLocation(palindromeSize, currentPalindromCenterLocation);
        if (((currentPalindromCenterLocation- rightEdge) + currentPalindromCenterLocation) >= arrayLength) {
            return true;
        }
        return false;
    }

    private static boolean isItANewRoot(int currentLocation, int currentPalindromCenterLocation, int[] palindromLenghtArray) {
        int currentRootPalindromeRightEdge = getPalindromeRightEdgeLocation(palindromLenghtArray[currentPalindromCenterLocation], currentPalindromCenterLocation);
        int currentLocationRightEdge = getPalindromeRightEdgeLocation(palindromLenghtArray[currentLocation], currentLocation);
        if (currentLocationRightEdge >= currentRootPalindromeRightEdge) {
            return true;
        }
        return false;
    }

    private static int canWeTakeMirrorPalindromeLength(int currentLocation, int currentPalindromCenterLocation, int[] palindromLenghtArray) {
        int distance = currentLocation - currentPalindromCenterLocation;
        int mirrorPalindromLocation = currentPalindromCenterLocation - distance;
        int RootPalindromeLeftEdge = getPalindromeLeftEdgeLocation(palindromLenghtArray[currentPalindromCenterLocation], currentPalindromCenterLocation);
        int mirrorPalindromeLeftEdge = getPalindromeLeftEdgeLocation(palindromLenghtArray[mirrorPalindromLocation], mirrorPalindromLocation);
        if (mirrorPalindromeLeftEdge < RootPalindromeLeftEdge) {
            return -1;
        }
        return palindromLenghtArray[mirrorPalindromLocation];
    }

    private static int getPalindromeLeftEdgeLocation(int palindromeSize, int currentLocation) {
        return currentLocation - (int) (palindromeSize / 2);
    }

    private static int getPalindromeRightEdgeLocation(int palindromeSize, int currentLocation) {
        return currentLocation + (int) (palindromeSize / 2);
    }

    private static boolean canWeChooseCurrentLocationAsNewRoot(int currentLocation, int currentPalindromCenterLocation, int[] palindromLenghtArray, char[] inputString) {
        int currentLocationPalindromLenght = getPalindromeLength(currentLocation, inputString,
                currentLocationPalindromeLeastSize(currentLocation, currentPalindromCenterLocation, palindromLenghtArray));

        boolean isCurrentLocationPalindromeLengthSameAsMirror = isCurrentLocationPalindromeLengthSameAsMirror(currentLocation, currentPalindromCenterLocation, currentLocationPalindromLenght, palindromLenghtArray);
        return isCurrentLocationPalindromeLengthSameAsMirror;
    }

    private static boolean isCurrentLocationPalindromeLengthSameAsMirror(int currentLocation, int currentPalindromCenterLocation, int currentLocationPalindromLenght, int[] palindromLenghtArray) {
        int distance = currentLocation - currentPalindromCenterLocation;
        if (palindromLenghtArray[currentPalindromCenterLocation - distance] == currentLocationPalindromLenght) {
            return true;
        }
        return false;
    }

    private static int getPalindromeLength(int currentLocation, char[] inputString, int leastPalindromeSize) {
        int LW = currentLocation - leastPalindromeSize;
        int RW = currentLocation + leastPalindromeSize;
        return findPalindromeLenght(LW, RW, inputString);
    }

    private static int currentLocationPalindromeLeastSize(int currentLocation, int currentPalindromCenterLocation, int[] palindromLenghtArray) {
        int distance = currentLocation - currentPalindromCenterLocation;
        return palindromLenghtArray[currentPalindromCenterLocation - distance];
    }

    private static boolean IfCurrentLocationUnderTheCurrentPalindrome(int rightWing, int currentLocation) {
        if (currentLocation <= rightWing) {
            return true;
        }
        return false;
    }

    private static int getPalindromeLength(int currentLocation, final char[] inputString) {
        int LW = currentLocation - 1;
        int RW = currentLocation + 1;
        return findPalindromeLenght(LW, RW, inputString);
    }

    private static int findPalindromeLenght(int LW, int RW, char[] inputString) {
        int palindromLength = 1;
        while (RW < inputString.length && LW >= 0) {
            if (inputString[LW] == inputString[RW]) {
                palindromLength = palindromLength + 2;
                LW--;
                RW++;
            } else {
                break;
            }
        }
        return palindromLength;
    }

}
