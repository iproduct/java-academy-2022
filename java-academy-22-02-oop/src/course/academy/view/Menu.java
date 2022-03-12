package course.academy.view;

import java.util.List;

public class Menu {
    public static class Option {
        private String text;
        private Command command;

        public Option(String text, Command command) {
            this.text = text;
            this.command = command;
        }

        public String getText() {
            return text;
        }

        public Command getCommand() {
            return command;
        }

        @Override
        public String toString() {
            return "MenuOption{" +
                    "text='" + text + '\'' +
                    ", command=" + command +
                    '}';
        }
    }
    public interface Command {
        String execute();
    }

    public class ExitCommand implements Command {
        @Override
        public String execute() {
            return null;
        }
    }

    private String title;
    private List<Option> options = List.of(new Option("Exit", new ExitCommand()));

    public Menu() {
    }

    public Menu(String title, List<Option> options) {
        this.title = title;
        this.options = options;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Menu)) return false;

        Menu menu = (Menu) o;

        if (getTitle() != null ? !getTitle().equals(menu.getTitle()) : menu.getTitle() != null) return false;
        return getOptions() != null ? getOptions().equals(menu.getOptions()) : menu.getOptions() == null;
    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getOptions() != null ? getOptions().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "title='" + title + '\'' +
                ", options=" + options +
                '}';
    }

    public void show() {
        System.out.printf("MENU: %s%n", title);
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("%2d. %s%n", i + 1, options.get(i).getText());
        }
    }

    public static void main(String[] args) {
        var menu = new Menu("Main Menu", List.of(
                new Option("Load Books", new Command() {
                    @Override
                    public String execute() {
                        System.out.println("Loading books ...");
                        return "Books loaded successfully.";
                    }
                }),
                new Option("Save Books", new Command() {
                    @Override
                    public String execute() {
                        System.out.println("Saving books ...");
                        return "Books saved successfully.";
                    }
                })
        ));
        menu.show();
    }
}
