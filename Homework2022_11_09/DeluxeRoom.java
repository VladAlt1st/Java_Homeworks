package Homework2022_11_09;

public class DeluxeRoom extends HotelRoom {

    public DeluxeRoom(int number, double price) {
        super(number, price);

    }

    @Override
    public String toString() {
        return "Deluxe " + super.toString();
    }
}
