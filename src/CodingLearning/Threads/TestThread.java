package CodingLearning.Threads;

public class TestThread {
    public static void main(String args[]) {

        ClassThread R1 = new ClassThread("Thread-1");
        R1.start();

        ClassThread R2 = new ClassThread("Thread-2");
        R2.start();
    }
}
