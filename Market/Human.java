package org.example.hw;

public class Human extends Buyer {

    public Human(String name) {
        super(name);
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    public void setMakeOrder() {
        isMakeOrderClass = true;
    }

    @Override
    public void setTakeOrder() {
        isTakeOrderClass = true;
    }

    @Override
    public boolean isMakeOrder() {
        return isMakeOrderClass;
    }

    @Override
    public boolean isTakeOrder() {
        return isTakeOrderClass;
    }
}
