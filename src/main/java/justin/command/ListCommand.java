package justin.command;

import justin.MainWindow;
import justin.Storage;
import justin.TaskList;
import justin.Ui;

/**
 * Represents a command that lists all the tasks
 * in the TaskList.
 * @author Justin Cheng.
 */
public class ListCommand extends Command {

    /**
     * Executes the command by showing the contents of the
     * TaskList through the Ui.
     * @param list The TaskList to carry out operations.
     * @param ui The Ui to send outputs.
     * @param storage The Storage to save changes.
     */
    @Override
    public void execute(TaskList list, Ui ui, Storage storage, MainWindow mw) {}

    @Override
    public String getMessage(TaskList list, Ui ui) {
        return ui.listMessage(list);
    }
}
