package Homework2022_10_19;

import java.util.ArrayList;

public class Check {

    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    private double getTotal() {
        double total = 0;
        for (Product p:products) {
            total += p.getPrice();
        }
        return total;
    }

    public void printCheck(){
        for(Product p:products) {
            System.out.println(p);
        }
        System.out.printf("Total = %.2f", getTotal());
    }
}
