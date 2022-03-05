package course.academy.model;

import java.util.ArrayList;
import java.util.List;

public class Author extends User{
    private List<String> ownBlogs = new ArrayList<>();

    public Author(Long id, String firstName, String lastName, int age, String username, String password, List<String> ownBlogs) {
        super(id, firstName, lastName, age, username, password, Role.AUTHOR, true);
        this.ownBlogs = ownBlogs;
    }

    public List<String> getOwnBlogs() {
        return ownBlogs;
    }

    public void setOwnBlogs(List<String> ownBlogs) {
        this.ownBlogs = ownBlogs;
    }

    @Override
    public String toString() {
        return "Author{" + super.toString() +
                " | ownBlogs=" + ownBlogs + "}";
    }
}
