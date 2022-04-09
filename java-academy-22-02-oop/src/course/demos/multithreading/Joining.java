package course.demos.multithreading;//: concurrency/Joining.java

class Sleeper extends Thread {
  private int duration;
  public Sleeper(String name, int duration) {
    super(name);
    duration = duration;
    start();
  }
  public void run() {
    try {
      sleep(duration);
    } catch(InterruptedException e) {
      System.out.println(getName() + " was interrupted. " +
        "isInterrupted: " + isInterrupted());
      return;
    }
    System.out.println(getName() + " was awakened");
  }
}

class Joiner extends Thread {
  private Sleeper sleeper;
  public Joiner(String name, Sleeper sleeper) {
    super(name);
    this.sleeper = sleeper;
    start();
  }
  public void run() {
   try {
      sleeper.join();
    } catch(InterruptedException e) {
     System.out.println("Thread was interrupted");
    }
    System.out.println("Joining with:" + getName());
  }
}

public class Joining {
  public static void main(String[] args) {
    Sleeper
      s1 = new Sleeper("Sleeper1", 1500),
      s2 = new Sleeper("Sleeper2", 1500);
    Joiner
      j1 = new Joiner("Joiner1", s1),
      j2 = new Joiner("Joiner2", s2);
    s2.interrupt();
  }
}
