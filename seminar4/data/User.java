package homework04.data;

/*
3. Принцип подстановки Барбары Лисков гласит что подклассы могли бы служить заменой для своих суперклассов.
Допустим если создать метод "умениеУчиться" вынести в отдельный интерфейс и имплементировать этот интерфейс в классе User,
реализовать в классах наследниках User.
Использование метода "умениеУчиться" не будет зависеть от типа данных,
главное чтобы классы использующие метод были наследниками User, т.е можно подставить вместо базового его подтип.
User teacher = new Teacher()
Для того чтобы следовать принципу подстановки необходимо избегать глубоких иерархий, а для связей использовать интерфейсы.
 */
abstract public class User {
    private String surname;
    private String firstname;
    private String patronymic;

    public User(String surname, String firstname, String patronymic) {
        if (firstname.isEmpty() || surname.isEmpty() || patronymic.isEmpty()) {
            throw new IllegalArgumentException("Имя фамилия или отчество должно быть заполнены");
        }
        this.surname = surname;
        this.firstname = firstname;
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getPatronymic() {
        return patronymic;
    }

    public void setFirstname(String firstname) {
        if (firstname.isEmpty()){
            throw new IllegalArgumentException("Фамилия не может быть пуста");
        }
        this.firstname = firstname;
    }
}
