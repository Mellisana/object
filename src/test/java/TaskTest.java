import org.example.Epic;
import org.example.Meeting;
import org.example.SimpleTask;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testMatchesForSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        assertTrue(simpleTask.matches("Позвонить"));
        assertFalse(simpleTask.matches("Пойти в магазин"));
    }

    @Test
    public void testMatchesForEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        assertTrue(epic.matches("Молоко"));
        assertFalse(epic.matches("Сыр"));
    }

    @Test
    public void testMatchesForMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        assertTrue(meeting.matches("Выкатка"));
        assertTrue(meeting.matches("НетоБанк"));
        assertFalse(meeting.matches("Понедельник"));
    }
}

