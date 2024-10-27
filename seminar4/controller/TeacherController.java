package homework04.controller;

import homework04.data.Teacher;
import homework04.service.TeacherService;
import homework04.view.TeacherView;

import java.util.List;

/*
5. Принцип инверсии зависимостей модули верхних уровней не должны зависеть от модулей нижних уровней.
Оба типа модулей должны зависеть от абстракций.
В классе TeacherController реализация методов добавления, поиска и вывода на экран списка учителей
зависит от интерфейсов UserService и UserView.
 */

// Обработка пользовательских действий и взаимодействие с другими классами
public class TeacherController {
    private final TeacherService teacherService;
    private final TeacherView teacherView;

    public TeacherController(TeacherService teacherService, TeacherView teacherView) {
        this.teacherService = teacherService;
        this.teacherView = teacherView;
    }
    public void create(Teacher teacher) {
        teacherService.create(teacher);
    }
    public void edit(int id, String newFirstname, String newSchoolSubject) {
        if (id < 0 || id > teacherService.all().size() - 1) {
            throw new IllegalArgumentException("id не найден");
        }
        if(newFirstname.isEmpty() || newSchoolSubject.isEmpty()){
            throw new IllegalArgumentException("Имя и фамилия не должны быть пусты");
        }
        teacherService.edit(id, newFirstname, newSchoolSubject);
    }
    public void printConsole() {
        List<Teacher> list = teacherService.all();
        if (list.isEmpty()) {
            throw new IllegalStateException("Список пуст");
        }
        teacherView.printConsole(list);
    }
}
