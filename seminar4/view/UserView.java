package homework04.view;

import homework04.data.User;
import java.util.List;

/*
4. Принцип разделения интерфейса гласит, создавайте узкоспециализированные интерфейсы.
Интерфейс UserView используется лишь для вывода списка наследников User.
 */

public interface UserView<T extends User> {
    void printConsole(List<T> list);
}
