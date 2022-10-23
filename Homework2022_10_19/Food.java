package Homework2022_10_19;

public class Food extends Product {
    private double priceForUrgency;

    public Food (String name, double price, double priceForUrgency) {
        super(name, price);
        this.priceForUrgency = priceForUrgency;
    }

    public double getPrice() {
        return  super.getPrice() + priceForUrgency;
    }

    @Override
    public String toString() {
        return String.format("%s, for urgency - %.2f",super.toString(),priceForUrgency);
    }
}
