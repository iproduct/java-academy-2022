package course.academy.model;

import course.academy.dao.Identifiable;

import java.util.List;
import java.util.StringJoiner;

import static course.academy.model.Role.READER;

public class User extends Person {
    private String username;
    private String password;
    private Role role = READER;
    private boolean active = true;

    public User() {
        super(); // by default - optional
    }

    public User(Long id) {
        super(id);
    }

    public User(String firstName, String lastName, int age, String username, String password) {
        super(firstName, lastName, age);
        this.username = username;
        this.password = password;
    }

    public User(Long id, String firstName, String lastName, int age, String username, String password) {
        super(id, firstName, lastName, age);
        this.username = username;
        this.password = password;
    }

    public User(Long id, String firstName, String lastName, int age, String username, String password, Role role, boolean active) {
        super(id, firstName, lastName, age);
        this.username = username;
        this.password = password;
        this.role = role;
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return new StringJoiner(" | ", "", "")
                .add(super.toString())
                .add("username='" + username + '\'')
                .add("password='" + password + '\'')
                .add("role=" + role )
                .add("active=" + active)
                .toString();
    }

    @Override
    public String format(String prefix){
        return String.format("%s %-15.15s | %-15.15s | %-6.6s | %5.5b |",
                super.format(prefix), username, password, role.name(), active);
    }

    private static String stringifyUsers(List<User> users) {
        StringJoiner stringJoiner = new StringJoiner("\n", "Users:\n", "");
        for(User u : users) {
            stringJoiner.add(u.toString());
        }
        return stringJoiner.toString();
    }

    public static void main(String[] args) {
        List<User> users = List.of(
                new Admin(1L, "John", "Doe", 35,
                        "john", "john123", "admin@mydomain.com"),
                new Author(2L, "Ivan", "Petrov", 25,
                        "ivan", "ivan123", List.of("Java", "Kotlin")),
                new Reader(3L, "Maria", "Petrova", 25,
                        "mary", "mary123", List.of("Java", "SOLID Principles"))
                );
        System.out.println(stringifyUsers(users));
    }

}
