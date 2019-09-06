package puke.task;

/**
 * Class representing a task to be done, but not at any particular time.
 */
public class Todo extends Task {
    /**
     * Initializes a Todo from its description.
     *
     * @param desc What is to be done.
     */
    Todo(String desc) {
        super(desc);
    }
    
    /**
     * Parses the given line and returns a Todo constructed from it.
     *
     * @param line The parsed line.
     */
    public static Todo parse(String line) throws IllegalArgumentException {
        if (line.isEmpty()) {
            throw new IllegalArgumentException("The description of a todo cannot be empty.");
        }
        return new Todo(line);
    }
    
    /**
     * Returns a string representation of this Todo.
     *
     * @return The desired string representation.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Exports this Todo for saving to disk.
     *
     * @return A string representation of this task containing the type marker T.
     */
    @Override
    public String export() {
        return "T|" + super.export() + "|";
    }
}
