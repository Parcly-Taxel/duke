package bari.task;

/**
 * A generic task, which can be marked as done.
 */
public class Task implements Comparable<Task> {
    private String desc;
    protected boolean done;

    /**
     * Initializes a task not yet done with the given description.
     *
     * @param desc A description of this task.
     */
    public Task(String desc) {
        this.desc = desc;
        this.done = false;
    }

    /**
     * Returns the description associated with this task.
     *
     * @return This task's description.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Marks this task as done.
     */
    public void markDone() {
        done = true;
    }
    
    /**
     * Gets a Unicode character representing whether this task is done.
     *
     * @return U+2713 (tick) if this task is done, U+2718 (cross) otherwise.
     */
    private String getDoneChar() {
        return done ? "✓" : "✘";
    }
    
    /**
     * Returns a string representation of this task.
     *
     * @return The desired string representation.
     */
    @Override
    public String toString() {
        String boxedChar = "[" + getDoneChar() + "]";
        return boxedChar + " " + desc;
    }

    /**
     * Exports this task in a short, ASCII-friendly format. Suitable for interchange
     * with other applications or just viewing bare.
     *
     * @return A string representation of this task containing its done status (0 or 1)
     *     and its description.
     */
    public String export() {
        return (done ? "1|" : "0|") + desc;
    }

    /**
     * Compares this Task against Task other. The type of task is compared first,
     * followed by the description.
     *
     * @param other The Task this Task will be compared to.
     * @return A positive integer if this > other, a negative integer if less and zero otherwise.
     */
    public int compareTo(Task other) {
        if (this.export().compareTo(other.export()) > 0) {
            return 1;
        } else if (this.export().compareTo(other.export()) < 0) {
            return -1;
        }
        return 0;
    }
}
