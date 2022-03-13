package course.academy.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            return String.format("Exiting menu '%s'.", Menu.this.title);
        }
    }

    // Main class methods and attributes.
    private String title;
    private List<Option> options = List.of(new Option("Exit", new ExitCommand()));
    private Scanner scanner = new Scanner(System.in);

    public Menu() {
    }

    public Menu(String title, List<Option> options) {
        this.title = title;
        var oldOptions= this.options;
        this.options = new ArrayList<>();
        this.options.addAll(options);
        this.options.addAll(oldOptions);
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
        while(true) {
            System.out.printf("\nMENU: %s%n", title);
            for (int i = 0; i < options.size(); i++) {
                System.out.printf("%2d. %s%n", i + 1, options.get(i).getText());
            }
//            var iter = options.listIterator(options.size());
//            var i = 1;
//            while (iter.hasPrevious()) {
//                System.out.printf("%2d. %s%n", i++, iter.previous().getText());
//            }
            int choice = -1;
            do {
                System.out.printf("Enter your choice (1 - %s):", options.size());
                var choiceStr = scanner.nextLine();
                try {
                    choice = Integer.parseInt(choiceStr);
                } catch (NumberFormatException ex) {
                    System.out.println("Error: Invalid choice. Please enter a valid number between 1 and " + options.size());
                }
            } while (choice < 1 || choice > options.size());
            var result = options.get(choice - 1).getCommand().execute();
            System.out.println(result);
            if(choice == options.size()) { // Exit command chosen
                break;
            }
        }
    }
}
