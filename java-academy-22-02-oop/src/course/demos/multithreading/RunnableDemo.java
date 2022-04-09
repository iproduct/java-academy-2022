package course.demos.multithreading;

public class RunnableDemo {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            new RocketLiftOff(i).run();
        }
    }
}
