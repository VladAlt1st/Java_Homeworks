package Homework2022_11_09;

public class SuperiorRoom extends HotelRoom {

    public SuperiorRoom(int numberOfRoom, double price, FitnessCenter fitnessCenter) {
        super(numberOfRoom, price, fitnessCenter);
    }

    @Override
    public String toString() {
        return "Superior " + super.toString();
    }
}
