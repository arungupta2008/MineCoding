package PorjectEuler;

/**
 * Created by arun.gupta on 29/05/16.
 */
public class Problem1 {
    public static void main(String[] args) {
        int total = 0;
        for(int i=1; i<1000; ++i){
            if(i %3 == 0 || i%5 == 0){
                total += i;
            }
        }
        System.out.println("total : "+total);
    }
}
