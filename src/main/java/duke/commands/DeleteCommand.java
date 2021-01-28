package duke.commands;

import duke.util.Storage;
import duke.util.TaskList;
import duke.tasks.Task;
import duke.ui.Ui;

public class DeleteCommand extends Command {

    public DeleteCommand(String input) {
        super(input);
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        String selectedTask = input;

        // checking if the task number is given and empty string or null
        if (selectedTask.trim().equals("")) {
            throw new NullPointerException("TASK NUM is Empty/Null: Returning to Main Menu");
        }

        int taskIndex = Integer.parseInt(selectedTask) - 1;
        if (taskIndex < 0 || taskIndex > taskList.size()) {
            throw new ArrayIndexOutOfBoundsException(
                    "TASK NUM cannot be found in the task list: Returning to Main Menu");
        }

        int previousTaskSize = taskList.size();
        Task task = taskList.remove(taskIndex);
        int subsequentTaskSize = taskList.size();
        assert (previousTaskSize == subsequentTaskSize - 1);
        return String.format("Noted. I've removed this task:\n"
                + "%s\n" + "Now you have %d tasks in the list.", task, taskList.size());

    }

    @Override
    public String toString() {
        return "delete <task taskIndex>";
    }


}