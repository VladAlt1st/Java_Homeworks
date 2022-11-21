package Homework2022_11_09.Camparators;

import Homework2022_11_09.Booking;

import java.util.Comparator;

public interface BookingComparatorFactory {

    public Comparator<Booking> getComparator();
}
