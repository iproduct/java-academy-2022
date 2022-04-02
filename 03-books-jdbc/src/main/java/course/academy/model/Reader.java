package course.academy.model;

import java.util.ArrayList;
import java.util.List;

public class Reader extends User{
    private List<String> favouriteBlogs = new ArrayList<>();

    public Reader(Long id, String firstName, String lastName, int age, String username, String password, List<String> favouriteBlogs) {
        super(id, firstName, lastName, age, username, password, Role.READER, true);
        this.favouriteBlogs = favouriteBlogs;
    }

    public List<String> getFavouriteBlogs() {
        return favouriteBlogs;
    }

    public void setFavouriteBlogs(List<String> favouriteBlogs) {
        this.favouriteBlogs = favouriteBlogs;
    }

    @Override
    public String toString() {
        return "Reader{" + super.toString() +
                " | favouriteBlogs=" + favouriteBlogs + "}";
    }
}
