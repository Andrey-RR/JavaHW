package homework04.view;

import homework04.data.Teacher;
import java.util.List;

// Отвечает за отображение информации об учителях.
public class TeacherView implements UserView<Teacher> {
    //Отображение списка учителей.
    @Override
    public void printConsole(List<Teacher> list) {
        for (Teacher teacher : list) {
            System.out.println(teacher);
        }
    }
}
