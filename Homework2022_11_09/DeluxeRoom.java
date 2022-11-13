package Homework2022_11_09;

public class DeluxeRoom extends HotelRoom {

    public DeluxeRoom(int numberOfRoom, double price) {
        super(numberOfRoom, price);

    }

    @Override
    public String toString() {
        return "Deluxe " + super.toString() + "; free fitness center";
    }
}
