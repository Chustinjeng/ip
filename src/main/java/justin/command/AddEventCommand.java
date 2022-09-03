package justin.command;

import justin.*;
import justin.task.Event;
import justin.task.Task;

/**
 * Represents a command that is called to add an event
 * task in the TaskList, and save changes.
 * @author Justin Cheng.
 */
public class AddEventCommand extends Command {
    private String description;
    private boolean isDone;
    private String at;
    private String time;
    private Event task;

    /**
     * Constructor for the AddEventCommand class
     * @param description The description of the event.
     * @param isDone The boolean value of whether the task is done.
     * @param at The date at which the event is happening.
     * @param time The time at which the event is happening.
     */
    public AddEventCommand(String description, boolean isDone, String at, String time) {
        this.description = description;
        this.isDone = isDone;
        this.at = at;
        this.time = time;
    }

    /**
     * Second constructor for the AddEventCommand class
     * @param description The description of the event.
     * @param msg The array of strings which contains details of the task,
     *            such as its date and time in string format.
     */
    public AddEventCommand(String description, String[] msg) {
        this.description = description;
        this.isDone = false;
        this.at = msg[1];
        this.time = msg[2];
    }

    /**
     * Executes the task, which consists of
     * adding task to TaskList, sending messages through Ui,
     * and saving tasks to Storage.
     * @param list The TaskList to carry out operations.
     * @param ui The Ui to send outputs.
     * @param storage The Storage to store changes.
     */
    @Override
    public void execute(TaskList list, Ui ui, Storage storage, MainWindow mw) {
        try {
            this.task = new Event(description, isDone, at, time);
            list.addTask(task);
            storage.save(list);
        } catch (DukeException e) {
            mw.handleException(e.getMessage());
        }
    }

    @Override
    public String getMessage(TaskList list, Ui ui) {
        return ui.addMessage(task) + ui.showLine() + ui.countMessage(list);
    }
}
