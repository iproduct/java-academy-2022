package course.academy.hello;

public class Person extends Object {
    private int age;
    private String name = "Anonymous";

    public int getAge(){
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Person)) return false;

        Person person = (Person) other;

        return this.getName().equals(person.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

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

        Person p3 = new Person();
        p3.age = 26;
        p3.name = "John Doe";
        System.out.println(p3);
        System.out.println(p1.equals(p3));
        System.out.println("p1.hash:" + p1.hashCode());
        System.out.println("p3.hash:" + p3.hashCode());
        System.out.println("p1.hash:" + System.identityHashCode(p1));
        System.out.println("p3.hash:" + System.identityHashCode(p3));
        System.out.println(p1 == p3);

        String s = "Hello";
        s = new String("Hello");
        System.out.println(s);
    }
}
