package course.academy.hello;

public class Person {
    private int age;
    private String name = "Anonymous";

    @Override
    public String toString(){
        return "Name:" + name + ", Age:" + age;
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.age = 25;
        p1.name = "John Doe";
        Person p2 = new Person();
        p2.age = 35;
        p2.name = "Mary Smith";
        System.out.println(p1.toString());
        System.out.println(p2);
    }
}
