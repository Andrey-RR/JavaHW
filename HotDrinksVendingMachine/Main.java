public class Main {
    public static void main(String[] args) {
        // Создание горячих напитков
        Coffee espresso = new Coffee("Espresso", 50, 80);
        Coffee latte = new Coffee("Latte", 200, 70);
        Coffee cappuccino = new Coffee("Cappuccino", 150, 75);

        // Инициализация автомата и добавление напитков
        HotDrinksVendingMachine vendingMachine = new HotDrinksVendingMachine();
        vendingMachine.addProduct(espresso);
        vendingMachine.addProduct(latte);
        vendingMachine.addProduct(cappuccino);

        // Получение напитка по параметрам
        System.out.println("Attempting to get Latte with 200ml at 70°C:");
        HotDrink selectedDrink = vendingMachine.getProduct("Latte", 200, 70);
        if (selectedDrink != null) {
            System.out.println("Received drink: " + selectedDrink);
        }

        // Попытка получить несуществующий напиток
        System.out.println("\nAttempting to get Americano with 150ml at 75°C:");
        HotDrink nonExistentDrink = vendingMachine.getProduct("Americano", 150, 75);
        if (nonExistentDrink != null) {
            System.out.println("Received drink: " + nonExistentDrink);
        }

        // Получение напитка без параметров
        System.out.println("\nGetting any available drink:");
        HotDrink anyDrink = vendingMachine.getProduct();
        if (anyDrink != null) {
            System.out.println("Received drink: " + anyDrink);
        }
    }
}
