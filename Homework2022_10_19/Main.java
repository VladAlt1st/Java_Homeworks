package Homework2022_10_19;

/*
Let's say we have a store. There are three categories of goods in our store:
groceries, electronics (mobile phones and laptops), clothing.
 Each product has a price and a name. Each item can be purchased (buyer invoiced).
    when buying products, an additional price is charged for the urgency of delivery.
    when buying electronics, the buyer is issued a guarantee (i.e., when buying, the “Issue a guarantee” method must be performed)
    phones are sold only with an operator contract (i.e., when buying, the “Place a contract” method must be completed)
    It is necessary to create an appropriate class structure for the product purchase method
*/

public class Main {
    public static void main(String[] args) {
        Check check = new Check();
        check.addProduct(new MobilePhone("Iphone10S", 1250));
        check.addProduct(new Laptop("Asus", 2200.30));
        check.addProduct(new Food("Pizza", 26.30, 4.40));
        check.addProduct(new Clothes("Pullover", 50.50));
        check.printCheck();
    }
}
