public class Task {
    protected String description;
    protected boolean isDone;
    public Task (String description) {
        this.description = description;
        isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }


    public String getDescription() {
        return description;
    }


    public void setDone(boolean done) {
        isDone = done;
    }

    public boolean markAsDone() {
        return isDone;
    }

    @Override
    public String toString() {
        return "description: " + description;
    }


}
