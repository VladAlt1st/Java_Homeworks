package Homework2022_11_09;

public abstract class HotelRoom {
    private int numberOfRoom;
    private double price;
    private boolean status = true;
    private FitnessCenter fitnessCenter;

    public HotelRoom(int numberOfRoom, double price, FitnessCenter fitnessCenter) {
        this.numberOfRoom = numberOfRoom;
        this.price = price;
        this.fitnessCenter = fitnessCenter;
    }

    public HotelRoom(int numberOfRoom, double price) {
        this.numberOfRoom = numberOfRoom;
        this.price = price;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public double getPrice() {
        return price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public FitnessCenter getFitnessCenterPass() {
        return fitnessCenter;
    }

    @Override
    public String toString() {
        String status = isStatus()? "not booked" : "booked";
        return String.format("room %d: price - %.2f; status - %s", numberOfRoom, price, status);
    }
}
