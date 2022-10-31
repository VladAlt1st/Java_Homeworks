package Homework2022_10_19;

public class Basket {
    private int size;
    private int capacity;
    private Product[] products;

    public Basket(int capacity) {
        this.capacity = capacity;
        products = new Product[capacity];
        size = 0;
    }

    public void add(Product product) {
        if (size >= products.length) {
            enlarge();
        }
        products[size] = product;
        size++;
    }

    private void enlarge() {
        Product[] newProducts = new Product[products.length * 2];
        for (int i = 0; i < products.length; i++) {
            newProducts[i] = products[i];
        }
        products = newProducts;
    }

    public String checkout() {
        StringBuilder res = new StringBuilder("Check:" + System.lineSeparator());
        for (int i = 0; i < products.length && i < size; i++) {
            res.append(products[i].toString()).append(System.lineSeparator());
        }
        res.append(getTotal());
        return res.toString();
    }

    private String getTotal() {
        double total = 0;
        for (int i = 0; i < products.length && i < size; i++) {
            total += products[i].getFullPrice();
        }
        return String.format("Total = %.2f", total);
    }
}
