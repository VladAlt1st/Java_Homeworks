package Homework2022_11_09;

public class PresidentRoom extends HotelRoom{

    public PresidentRoom(int numberOfRoom, double price) {
        super(numberOfRoom, price);
    }

    @Override
    public String toString() {
        return "President " + super.toString() + "; free fitness center";
    }
}
