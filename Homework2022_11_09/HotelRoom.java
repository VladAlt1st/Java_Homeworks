package Homework2022_11_09;

public abstract class HotelRoom {
    private int number;
    private double price;

    public HotelRoom(int number, double price) {
        this.number = number;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("room %d: price - %.2f", number, price);
    }


}
