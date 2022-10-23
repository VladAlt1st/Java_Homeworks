package Homework2022_10_19;

public class MobilePhone extends Electronics {

    public MobilePhone(String name, double price) {
        super(name, price);
    }

    private String addContract() {
        return "+ operator contract";
    }

    @Override
    public String toString() {
        return String.format("Phone - %s, %s",super.toString(),addContract());
    }
}
