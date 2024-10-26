import java.util.ArrayList;
import java.util.List;

public class HotDrinksVendingMachine implements VendingMachine<HotDrink> {
    private List<HotDrink> drinks;

    public HotDrinksVendingMachine() {
        this.drinks = new ArrayList<>();
    }

    public void addProduct(HotDrink drink) {
        drinks.add(drink);
    }

    @Override
    public HotDrink getProduct() {
        if (drinks.isEmpty()) {
            System.out.println("The vending machine is empty.");
            return null;
        }
        return drinks.remove(0);
    }

    // Overloaded method
    public HotDrink getProduct(String name, int volume, int temperature) {
        for (HotDrink drink : drinks) {
            if (drink instanceof Coffee) {
                Coffee coffee = (Coffee) drink;
                if (coffee.getName().equalsIgnoreCase(name) &&
                        coffee.getVolume() == volume &&
                        coffee.getTemperature() == temperature) {
                    drinks.remove(coffee);
                    return coffee;
                }
            }
        }
        System.out.println("Product not found.");
        return null;
    }
}
