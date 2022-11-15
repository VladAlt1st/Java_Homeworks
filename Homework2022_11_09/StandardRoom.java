package Homework2022_11_09;

public class StandardRoom extends HotelRoom{

    public StandardRoom(int number, double price) {
        super(number, price);
    }

    @Override
    public String toString() {
        return "Standard " + super.toString();
    }
}
