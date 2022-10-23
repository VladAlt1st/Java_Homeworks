package Homework2022_10_17._01;

public class Ticket {
    private Route route;
    private MyDateTime time;
    private double price;

    public Ticket(Route route, MyDateTime time, double price) {
        this.route = route;
        this.time = time;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s \n %s \n price: %.2f",
                route, time, price);
    }

    public double getPrice() {
        return price;
    }

    public long getDistance() {
        return route.getDistance();
    }

    public void setTime(MyDateTime time) {
        this.time = time;
    }
}
