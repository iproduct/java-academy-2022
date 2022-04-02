package course.academy.model;

public class Admin extends User{
    private String email;

    public Admin(Long id, String firstName, String lastName, int age, String username, String password, String email) {
        super(id, firstName, lastName, age, username, password, Role.ADMIN, true);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Admin{" + super.toString() +
                " | email=" + email + "}";
    }
}
