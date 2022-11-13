package Homework2022_11_09;

public class FitnessCenter {

    private double price = 30;
    private boolean isAvailable;

    public FitnessCenter(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
