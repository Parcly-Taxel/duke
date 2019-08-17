package parser;

import java.util.Scanner;
import command.*;
import task.Deadline;
import task.Event;
import task.Todo;

public class Parser {
    private final Scanner sc = new Scanner(System.in);

    /**
     * Parses a command from its two parts and returns a Command object.
     * @param cmd The command's first word, which dictates the rest of the
     *            command's structure.
     * @param data The data associated with the command, which may be the empty string.
     * @return The corresponding Command object.
     */
    private Command parse(String cmd, String data) {
        switch (cmd) {
            case "bye":
                return new ExitCommand();
            case "list":
                return new ListCommand();
            case "done":
                return new DoneCommand(Integer.parseInt(data));
            case "delete":
                return new DeleteCommand(Integer.parseInt(data));
            case "todo":
                return new AddCommand(Todo.parse(data));
            case "event":
                return new AddCommand(Event.parse(data));
            case "deadline":
                return new AddCommand(Deadline.parse(data));
            default:
                throw new IllegalArgumentException("I'm sorry, " +
                        "but I don't know what that means :-(");
        }
    }

    /**
     * Scans the next line from standard input, returning a Command.
     * @return The Command object corresponding to the scanned line.
     */
    public Command parseLine() {
        String cmd = sc.next();
        String data = sc.nextLine().trim();
        return parse(cmd, data);
    }
}
