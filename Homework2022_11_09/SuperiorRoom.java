package Homework2022_11_09;

public class SuperiorRoom extends HotelRoom {

    public SuperiorRoom(int number, double price) {
        super(number, price);
    }

    @Override
    public String toString() {
        return "Superior " + super.toString();
    }
}
