package course.academy.model;

import java.util.Date;
import java.util.StringJoiner;

import static course.academy.model.Role.*;

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

    public static void main(String[] args) {
        var u1 = new User(1L, "John", "Doe", 35,
                "john", "john123", ADMIN, true);
        var u2 = new User(2L, "Ivan", "Petrov", 25,
                "ivan", "ivan123", AUTHOR, true);
        System.out.println(u1.format("User "));
        System.out.println(u2.format("User "));
    }

}
