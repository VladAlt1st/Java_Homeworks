package Homework2022_10_17._01;

/*
Imagine you are writing a program for a fleet of vehicles or, for example, for an airline.
You need to create a class Ticket , which should contain the following fields Route route, MyDateTime time, double price.
As you can imagine, Route and MyDateTime are also classes:
Route{String number, String from, String destination, long distance}
MyDateTime (day,month,year,hour,min). Next you need:
        a) create several different tickets, put them in an array.
        b) Implement a method that displays information about all tickets
        c) Implement a method that calculates the total cost of tickets.
        d) It is necessary to calculate the total distance of all routes (assume that you do not have tickets with the same route, i.e. the task is reduced to a simple summation of all distances)
        e) Implement a method for changing the departure time in the ticket.
*/

public class Main {
    public static void main(String[] args) {
        Ticket t1 = new Ticket(
                new Route("1","Berlin","Dresden",322),
                new MyDateTime(10,5,2022,14,45),
                220.50);
        Ticket t2 = new Ticket(
                new Route("2", "Berlin", "Hamburg",412),
                new MyDateTime(11,5,2022,19,0),
                310.30);
        Ticket t3 = new Ticket(
                new Route("3", "Dresden", "Hamburg",500),
                new MyDateTime(5,6,2022,8,30),
                390);

        Ticket[] tickets = {t1, t2, t3};
        printTicketsInfo(tickets);
        System.out.println(calcTicketsPrice(tickets));
        System.out.println(calcSumOfDistance(tickets));
    }

    public static void printTicketsInfo(Ticket[] tickets) {
        for (Ticket t:tickets) {
            System.out.println(t.toString());
        }
    }

    public static double calcTicketsPrice(Ticket[] tickets) {
        double sumOfTicketsPrice = 0;
        for (Ticket t:tickets) {
            sumOfTicketsPrice += t.getPrice();
        }
        return sumOfTicketsPrice;
    }

    public static long calcSumOfDistance(Ticket[] tickets) {
        long sumOfDistance = 0;
        for (Ticket t:tickets) {
            sumOfDistance += t.getDistance();
        }
        return sumOfDistance;
    }
}
