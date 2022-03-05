package course.academy.model;

import java.util.StringJoiner;

public class Person {
    private static long nextId = 0;
    private final Long id; // blank final
    private String firstName;
    private String lastName;
    private int age;

    public Person() {
        id = ++nextId;
    }

    public Person(Long id) {
        this.id = id;
    }

    public Person(String firstName, String lastName, int age) {
        id = ++nextId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person(Long id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        return getId() != null ? getId().equals(person.getId()) : person.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return new StringJoiner(" | ", "", "")
                .add("id=" + id)
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("age=" + age)
                .toString();
    }

    public String format(final String prefix) {
//        prefix = prefix.toUpperCase();
        return String.format("%s| %4d | %-12.12s | %-12.12s | %3d |",
                prefix, id, firstName, lastName, age);
    }

    public static void main(String[] args) {
        var p1 = new Person(1L, "John", "Doe", 35);
        var p2 = new Person(2L, "Ivan", "Petrov", 28);
        System.out.println(p1.format("Person "));
        System.out.println(p2.format("Person "));
    }
}







