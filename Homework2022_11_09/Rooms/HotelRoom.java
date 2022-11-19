package Homework2022_11_09.Rooms;

public abstract class HotelRoom {
    private int number;
    private double price;
    private String type;

    public HotelRoom(int number, double price, String type) {
        this.number = number;
        this.price = price;
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("%s room %d: price - %.2f",type, number, price);
    }


}
