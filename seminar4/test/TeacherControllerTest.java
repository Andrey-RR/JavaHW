package homework04.test;

import homework04.controller.TeacherController;
import homework04.data.Teacher;
import homework04.service.TeacherService;
import homework04.view.TeacherView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TeacherControllerTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    TeacherService teacherService;
    TeacherView teacherView;
    TeacherController teacherController;

    @BeforeEach
    void prepareData(){
        System.setOut(new PrintStream(outputStreamCaptor));
        teacherService = new TeacherService();
        teacherView = new TeacherView();
        teacherController = new TeacherController(teacherService, teacherView);
    }
    @Test
    void create() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Teacher teacher = new Teacher("", "Иванович", "Иванов", "Физика");
            teacherController.create(teacher);
        });
        assertEquals("Имя фамилия или отчество должно быть заполнены", exception.getMessage());
    }
    @Test
    void create2() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Teacher teacher = new Teacher("Иванов", "", "Иванов", "Физика");
            teacherController.create(teacher);
        });
        assertEquals("Имя фамилия или отчество должно быть заполнены", exception.getMessage());
    }
    @Test
    void create3() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Teacher teacher = new Teacher("Иванов", "Иван", "", "Физика");
            teacherController.create(teacher);
        });
        assertEquals("Имя фамилия или отчество должно быть заполнены", exception.getMessage());
    }
    @Test
    void create4() {
        Teacher teacher = new Teacher("Иванов", "Иван", "Иванович", "");
        teacherController.create(teacher);
        assertEquals(1, teacherService.all().size());
    }
    @Test
    void create5() {
        Teacher teacher = new Teacher("Иванов", "Иван", "Иванович", "Физика");
        teacherController.create(teacher);
        assertEquals(1, teacherService.all().size());
    }

    @Test
    void edit() {
        Teacher teacher = new Teacher("Иванов", "Иван", "Иванович", "Физика");
        teacherController.create(teacher);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            teacherController.edit(1, "Иванов", "Химия");
        });
        assertEquals("id не найден", exception.getMessage());
    }

    @Test
    void edit2() {
        Teacher teacher = new Teacher("Иван", "Иванов", "Иванович", "Физика");
        teacherController.create(teacher);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            teacherController.edit(0, "", "Химия");
        });
        assertEquals("Имя и фамилия не должны быть пусты", exception.getMessage());
    }
    @Test
    void edit3() {
        Teacher teacher = new Teacher("Иван", "Иванов", "Иванович", "Физика");
        teacherController.create(teacher);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            teacherController.edit(0, "Петров", "");
        });
        assertEquals("Имя и фамилия не должны быть пусты", exception.getMessage());
    }

    @Test
    void edit4() {
        Teacher teacher = new Teacher("Иван", "Иванов", "Иванович", "Физика");
        teacherController.create(teacher);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            teacherController.edit(0, "", "");
        });
        assertEquals("Имя и фамилия не должны быть пусты", exception.getMessage());
    }

    @Test
    void edit5() {
        Teacher teacher = new Teacher("Иван", "Иванов", "Иванович", "Физика");
        teacherController.create(teacher);
        teacherController.edit(0, "Петров", "Химия");
        assertEquals("id-0 Иван Петров Иванович Химия", teacher.toString());
    }

    @Test
    void printConsole() {
        Teacher teacher = new Teacher("Иван", "Иванов", "Иванович", "Физика");
        Teacher teacher2 = new Teacher("Иван", "Иванов", "Иванович", "Физика");
        teacherController.create(teacher);
        teacherController.create(teacher2);
        teacherController.printConsole();
        assertEquals("id-0 Иван Иванов Иванович Физика\n" +
                "id-1 Иван Иванов Иванович Физика", outputStreamCaptor.toString().trim());
    }
}
