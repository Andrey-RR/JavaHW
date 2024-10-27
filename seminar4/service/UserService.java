package homework04.service;

import vvhomework04.data.User;

import java.util.List;

/*
2. Принцип открытости/закрытости гласит что сущности (классы, модули, функции)
должны быть открыты для расширения, но не для модификации.
С помощью данного интерфейса мы можем реализовать не только создание, редактирования и получения списка учителей,
но и учеников переопределив методы интерфейса и реализовав в них дополнительный функционал.
 */

public interface UserService<T extends User>{
    void create(T user);
    default void edit(String newSurname, String newFirstname){};
    List<T> all();
}
