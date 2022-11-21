package Homework2022_11_09.Camparators;

import Homework2022_11_09.Booking;

import java.util.Comparator;

public class CompareByBookingNumber implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        return o1.getBookingNumber() - o2.getBookingNumber();
    }
}
