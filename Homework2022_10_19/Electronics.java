package Homework2022_10_19;

public class Electronics extends Product {

    public Electronics(String name, double price) {
        super(name, price);
    }

    private String addGuarantee() {
        return "+ guarantee";
    }

    @Override
    public String toString() {
        return String.format("%s, %s",super.toString(),addGuarantee());
    }
}
