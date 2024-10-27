package homework04.service;

import homework04.data.Teacher;
import java.util.ArrayList;
import java.util.List;

// Логика работы с учителями
public class TeacherService implements UserService<Teacher> {
    private List<Teacher> teachers;
    public TeacherService() {
        teachers = new ArrayList<>();
    }
    // Создание учителей
    @Override
    public void create(Teacher teacher) {
        teacher.setIdTeacher(teachers.size());
        teachers.add(teacher);
    }
    // Редактирование учителя
    public void edit(int id, String newFirstname, String newSchoolSubject) {
        for (Teacher teacher : teachers) {
            if (teacher.getIdTeacher() == id) {
                teacher.setFirstname(newFirstname);
                teacher.setSchoolSubject(newSchoolSubject);
            }
        }
    }
    // Получение списка учителей
    @Override
    public List<Teacher> all() {
        return teachers;
    }
}
