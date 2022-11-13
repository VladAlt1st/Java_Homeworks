package Homework2022_11_09;

public class StandardRoom extends HotelRoom{

    public StandardRoom(int numberOfRoom, double price, FitnessCenter fitnessCenter) {
        super(numberOfRoom, price, fitnessCenter);
    }

    @Override
    public String toString() {
        return "Standard " + super.toString();
    }
}
