package org.example.hw;

import java.util.*;

public class Market implements MarketBehavior, QueueBehavior {
    private List<Buyer> actors = new LinkedList<>();
    private Queue<Buyer> actorsQueue = new ArrayDeque<>();

    @Override
    public void acceptToMarket(Buyer actor) {
        System.out.println(actor.getName() + " зашел в магазин");
        actors.add(actor);
    }

    @Override
    public void releaseFromMarket(Buyer actor) {
        actors.remove(actor);
        System.out.println(actor.getName() + " покинул магазин");
    }

    @Override
    public void update() {
        System.out.println("Обновление состояния магазина...");
        // Здесь можно добавить логику обработки заказов, статистики и т.д.
    }

    @Override
    public void takeInQueue(Buyer actor) {
        actorsQueue.add(actor);
        System.out.println(actor.getName() + " встал в очередь");
    }

    @Override
    public void takeOrder() {
        Buyer currentBuyer = actorsQueue.peek();
        if (currentBuyer != null) {
            currentBuyer.setTakeOrder();
            System.out.println(currentBuyer.getName() + " забрал заказ");
        } else {
            System.out.println("Очередь пуста, нет кого обслуживать для взятия заказа.");
        }
    }

    @Override
    public void giveOrder() {
        Buyer currentBuyer = actorsQueue.peek();
        if (currentBuyer != null) {
            currentBuyer.setMakeOrder();
            System.out.println(currentBuyer.getName() + " сделал заказ");
        } else {
            System.out.println("Очередь пуста, нет кого обслуживать для выдачи заказа.");
        }
    }

    @Override
    public void releaseFromQueue() {
        Buyer currentBuyer = actorsQueue.poll();
        if (currentBuyer != null) {
            System.out.println(currentBuyer.getName() + " покинул очередь");
        } else {
            System.out.println("Очередь пуста, нечего освобождать.");
        }
    }
}
