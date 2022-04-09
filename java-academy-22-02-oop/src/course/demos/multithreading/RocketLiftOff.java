package course.demos.multithreading;

public class RocketLiftOff implements Runnable {
    private int n;

    public RocketLiftOff(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        for(int i = 10; i >0; i--) {
            System.out.printf("Rocket %d [Thread: %s]: Countdown: %d%n", n, Thread.currentThread().getName(), i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.printf("Countdown interrupted for Rocket %d%n", n);
            }
        }
        System.out.printf("Rocket %d: LiftOff!!!", n);
    }
}


