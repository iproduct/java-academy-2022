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
    public class ExitCommand implements Command{

        @Override
        public String execute() {
            return null;
        }
    }

    private String title;
    private List<Option> options = List.of(new Option("Exit", new ExitCommand()));
}
