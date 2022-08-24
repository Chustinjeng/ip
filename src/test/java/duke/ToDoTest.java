package duke;

import duke.ToDo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {
    @Test
    public void dummyTest1() {
        assertEquals("[T][ ] Homework", new ToDo("Homework").toString());
    }

    @Test
    public void dummyTest2() {
        ToDo task = new ToDo("Coding Assignment");
        task.mark();
        assertEquals("[T][X] Coding Assignment", task.toString());
    }
}
