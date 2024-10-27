package org.example.hw;

public class Main {
    public static void main(String[] args) {

        Human hm1 = new Human("Roman");
        Human hm2 = new Human("Anna");
        Human hm3 = new Human("Ivan");

        Market market = new Market();

        // Пример работы с первым покупателем
        market.acceptToMarket(hm1);
        market.takeInQueue(hm1);
        market.giveOrder();
        market.takeOrder();
        market.releaseFromQueue();
        market.releaseFromMarket(hm1);

        // Пример работы с остальными покупателями
        market.acceptToMarket(hm2);
        market.acceptToMarket(hm3);

        market.takeInQueue(hm2);
        market.takeInQueue(hm3);

        market.giveOrder();
        market.takeOrder();
        market.releaseFromQueue();

        market.giveOrder();
        market.takeOrder();
        market.releaseFromQueue();

        market.releaseFromMarket(hm2);
        market.releaseFromMarket(hm3);

        market.update();
    }
}
