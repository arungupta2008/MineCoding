package AlgorithmProblems.DynamicProgramming;

import Helper.MatrixHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by arun.gupta on 05/07/16.
 *
 * input
 Tushar Likes to write code at free
 exit


 Nights into Dreams... is an action video game developed by Sonic Team and published by Sega for the Sega Saturn in
 1996. The story follows two teenagers, Claris and Elliot, who enter a dream world called Nightopia where all dreams
 take place. With the help of Nights, they begin a journey to stop the evil ruler Wizeman from destroying Nightopia
 and consequently the real world. Nights flies through Claris and Elliot's dreams, gathering energy to defeat Wizeman
 and save Nightopia. Development began soon after the release of Sonic & Knuckles in 1994, and was led by Sonic Team
 veterans Yuji Naka, Naoto Ohshima, and Takashi Iizuka. Naka began the project with flight as a main theme, and
 Ohshima  designed the character Nights to resemble an angel that could fly like a bird. An analogue controller,
 known  as the Saturn 3D controller, was designed alongside the game. Nights into Dreams... received positive reviews
 upon release; critics praised the graphics, gameplay, soundtrack, and atmosphere. It has been included on multiple
 lists as the best Sega Saturn game of all time, as well as one of the best video games ever made. (Full article...)
 exit
 *
 */
public class TextJustification {

    public static void main(String[] args) throws IOException {
        List<String> inputList = getInput();
        int lineLenght = 80;
        JustifyText(inputList, lineLenght);
    }

    private static void JustifyText(List<String> inputList, int lineLenght) {
        int size = inputList.size();
        Integer costMatrix[][] = createCostMatrix(inputList, inputList.size(), inputList.size(), lineLenght);
        MatrixHelper.PrintMatrix(costMatrix, inputList.size(), inputList.size());
        int [] locationArray = new int[size];
        int [] weightArray = new int[size];

        for(int i = size-1; i>=0; --i){
            for (int j= size-1; j > 0; --j){
                if(costMatrix[i][j] == null){
                    int min = Integer.MAX_VALUE;
                    int location = 0;
                    for(int k = j; k>i; --k){
                        if(costMatrix[i][k - 1] == null)
                            continue;
                        int cost = costMatrix[i][k - 1] + weightArray[k];
                        if(cost<min){
                            min = cost;
                            location = k;
                        }
                    }
                    weightArray[i] = min;
                    locationArray[i] = location;
                }else {
                    weightArray[i] = costMatrix[i][j];
                    locationArray[i] = j+1;
                }
                break;
            }
        }
        System.out.println(" Location : "+ Arrays.toString(locationArray));
        System.out.println(" weight : "+ Arrays.toString(weightArray));

        printResult(locationArray, inputList);


    }

    private static void printResult(int[] locationArray, List<String> inputList) {
        for(int i = 0; i< locationArray.length;){
            int j = i;
            for (; j<locationArray[i]; ++j){
                System.out.print(inputList.get(j)+ " ");
            }
            i = j;
            System.out.println();
        }
    }

    private static Integer[][] createCostMatrix(List<String> inputList, int row, int column, int lineLength) {
        List<Integer> inputSizeMatrix = getInputSizeInputList(inputList);
        Integer [][] costMatrix = new Integer[row][column];
        MatrixHelper.FillMatrix(costMatrix, null, inputList.size(), inputList.size());
        for(int i = 0; i< row;++i){
            for(int j = i; j< column;++j){
                costMatrix[i][j] = calculateCost(inputSizeMatrix,i,j,lineLength);
            }
        }
        return costMatrix;
    }

    private static Integer calculateCost(List<Integer> inputSizeMatrix, int i, int j, int lineLength) {
        int leftSpace = 0;
        boolean shouldAdded = false;
        for(int k = i; k<=j; ++k){
            leftSpace += inputSizeMatrix.get(k);
            if (shouldAdded){
                leftSpace += 1;
            }else {
                shouldAdded = true;
            }
        }
        return leftSpace <= lineLength ? BadFacor(lineLength-leftSpace) : null;
    }

    private static int BadFacor(int leftSpace) {
        return leftSpace*leftSpace;
    }


    private static List<Integer> getInputSizeInputList(List<String> inputList) {
        List<Integer> inputsizeList = new ArrayList<>();
        for(String input : inputList){
            inputsizeList.add(input.length());
        }
        return inputsizeList;
    }

    public static List<String> getInput() throws IOException {
        String line = "";
        List<String> inputList = new ArrayList<>();

        System.out.println(" Please enter the Data : ");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(isr);
        do
        {
            // It does takes Empty Lines which is wrong.
            line = bufferedReader.readLine();
            inputList.addAll(Arrays.asList(line.split("\\s+")));
        }while(!line.equals("exit"));
        isr.close();
        bufferedReader.close();
        System.out.println(inputList);

        return inputList;
    }
}
