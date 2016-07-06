package CodingLearning.DesignPattern.DecorativePattern.JavaIO;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by arun.gupta on 18/06/16.
 */
public class LowerCaseStreamTest {


    public static void main(String[] args) throws IOException {
        int c = 0;
        InputStream in = new LowerCaseInputStream(new BufferedInputStream(System.in));
        while ((c= in.read()) >= 0){
            System.out.print((char) c);
        }
        in.close();
    }
}
