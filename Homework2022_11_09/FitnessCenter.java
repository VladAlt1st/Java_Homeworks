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

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        String status = isAvailable()? "available" : "not available";
        if(isAvailable) {
            return String.format("Fitness center: %s; price - %.2f", status, price);
        }
        return String.format("Fitness center: %s", status);
    }
}
