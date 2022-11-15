package Homework2022_11_09;

public class PresidentRoom extends HotelRoom{

    public PresidentRoom(int number, double price) {
        super(number, price);
    }

    @Override
    public String toString() {
        return "President " + super.toString();
    }
}
