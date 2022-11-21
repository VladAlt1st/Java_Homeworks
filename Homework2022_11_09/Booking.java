package Homework2022_11_09;

import Homework2022_11_09.Rooms.HotelRoom;

public class Booking implements Comparable<Booking> {

    private HotelRoom room;
    private DateTime from;
    private DateTime to;
    private FitnessCenter fitnessCenter;
    private int bookingNumber;

    public Booking(HotelRoom room, DateTime from, DateTime to, FitnessCenter fitnessCenter, int bookingNumber) {
        this.room = room;
        this.from = from;
        this.to = to;
        this.fitnessCenter = fitnessCenter;
        this.bookingNumber = bookingNumber;
    }

    public HotelRoom getRoom() {
        return room;
    }

    public DateTime getFrom() {
        return from;
    }

    public DateTime getTo() {
        return to;
    }

    public FitnessCenter getFitnessCenter() {
        return fitnessCenter;
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    public double getTotal() {
        int bookingDays = DateTime.daysBetween(from, to);
        double totalPerDay = room.getPrice();
        if(fitnessCenter.isAvailable()) {
            totalPerDay += fitnessCenter.getPrice();
        }
        return totalPerDay * bookingDays;
    }

    @Override
    public String toString() {
        return String.format("Booking %d:%n %s;%n %s;%n From %s to %s;%n Total - %.2f.",
                getBookingNumber(), room.toString(),fitnessCenter.toString(),from.toString(),to.toString(),getTotal());
    }

    @Override
    public int compareTo(Booking o) {
        return this.getBookingNumber() - o.getBookingNumber();
    }
}
