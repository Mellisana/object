import org.example.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchByQuery() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expectedResultForParents = {simpleTask};
        Task[] actualResultForParents = todos.search("родителям");
        assertArrayEquals(expectedResultForParents, actualResultForParents);

        Task[] expectedResultForVersion = {meeting};
        Task[] actualResultForVersion = todos.search("версия");
        assertArrayEquals(expectedResultForVersion, actualResultForVersion);

        Task[] expectedResultForMilk = {epic};
        Task[] actualResultForMilk = todos.search("молоко");
        assertArrayEquals(expectedResultForMilk, actualResultForMilk);

        Task[] expectedEmptyResult = {};
        Task[] actualEmptyResult = todos.search("несуществующий запрос");
        assertArrayEquals(expectedEmptyResult, actualEmptyResult);
    }

    @Test
    public void SearchTask() {
        SimpleTask simpleTask1 = new SimpleTask(1, "Позвонить маме");
        SimpleTask simpleTask2 = new SimpleTask(2, "Купить продукты");
        Epic epic = new Epic(3, new String[]{"Написать отчет"});
        Meeting meeting = new Meeting(4, "Обсудить проект", "Проект А", "Среда");

        Todos todos = new Todos();
        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic);
        todos.add(meeting);

        Task[] foundTasks = todos.search("рассказать");

        Task[] expectedTasks = {};
        assertArrayEquals(expectedTasks, foundTasks);
    }

    @Test
    public void SearchFoundOneTask() {
        SimpleTask simpleTask1 = new SimpleTask(1, "Позвонить маме");
        SimpleTask simpleTask2 = new SimpleTask(2, "Купить продукты");
        Epic epic = new Epic(3, new String[]{"Написать отчет"});
        Meeting meeting = new Meeting(4, "Обсудить проект", "Проект А", "Среда");

        Todos todos = new Todos();
        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic);
        todos.add(meeting);

        Task[] foundTasks = todos.search("мам");

        Task[] expectedTasks = {simpleTask1};
        assertArrayEquals(expectedTasks, foundTasks);
    }

    @Test
    public void testSearchFoundTasks() {
        SimpleTask simpleTask1 = new SimpleTask(1, "Позвонить маме");
        SimpleTask simpleTask2 = new SimpleTask(2, "Купить продукты");
        Epic epic = new Epic(3, new String[]{"Написать отчет"});
        Meeting meeting = new Meeting(4, "Обсудить проект", "Проект А", "Среда");

        Todos todos = new Todos();
        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic);
        todos.add(meeting);

        Task[] foundTasks = todos.search("про");

        Task[] expectedTasks = {simpleTask2, epic};
        assertArrayEquals(expectedTasks, foundTasks);
    }
}