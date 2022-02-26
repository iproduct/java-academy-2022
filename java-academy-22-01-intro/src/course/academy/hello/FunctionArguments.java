package course.academy.hello;


class  MyInteger{
    private int n;

    public MyInteger(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    @Override
    public String toString() {
        return "MyInteger{" +
                "n=" + n +
                '}';
    }
}
public class FunctionArguments {
    static void update(MyInteger formalArg) {
//        formalArg.setN(formalArg.getN() + 1);
        formalArg = new MyInteger(formalArg.getN() + 1);
    }

    public static void main(String[] args) {
        MyInteger actualArg = new MyInteger(12);
        System.out.println("Before: " + actualArg);
        update(actualArg);
        System.out.println("After: " + actualArg);
    }
}
