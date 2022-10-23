package Homework2022_10_19;

public class Laptop extends Electronics{

    public Laptop(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Laptop - " + super.toString();
    }
}
