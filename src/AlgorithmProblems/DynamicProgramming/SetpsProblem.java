package AlgorithmProblems.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by arun.gupta on 23/04/16.
 */
/*
* Count number of ways to cover a distance
* Input:  n = 3
Output: 4
Below are the four ways
 1 step + 1 step + 1 step
 1 step + 2 step
 2 step + 1 step
 3 step
* */
public class SetpsProblem {
    public static void main(String[] args) {
        List<Integer> setps = new ArrayList<Integer>(Arrays.asList(1,2,3));
        int distance = 10;
        int currentStepsDistance = 0;
        //System.out.println("Steps : "+countSetps(distance,setps,currentStepsDistance));
        System.out.println("Steps with unique Steps : "+countSetpsWithUniqueSteps(distance,setps,currentStepsDistance));
    }


    private static int countSetps(int distance, List<Integer> setps, int currentStepsDistance) {
        int response = 0;
        if(currentStepsDistance == distance){
             response =  1;
        } else if(currentStepsDistance > distance){
            response =  0;
        }else {
            for (int step : setps) {
                response = response + countSetps(distance, setps, step + currentStepsDistance);
            }
        }
        return response;
    }

    private static int countSetpsWithUniqueSteps(int distance, List<Integer> setps, int currentStepsDistance) {
        int response = 0;
        if(currentStepsDistance == distance){
            response =  1;
        } else if(currentStepsDistance > distance){
            response =  0;
        }else {
            List<Integer> iterRatorSet = new ArrayList<Integer>(setps);
            for (int step : iterRatorSet) {
                List<Integer> newSteps = new ArrayList<Integer>(setps);
                newSteps.remove(step);
                response = response + countSetps(distance, newSteps, step + currentStepsDistance);
            }
        }
        return response;
    }
}
