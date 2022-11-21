package Homework2022_11_09.Camparators;

import Homework2022_11_09.Booking;

import java.util.Comparator;
import java.util.Scanner;

public class BookingComparatorByScanner implements BookingComparatorFactory{

    @Override
    public Comparator<Booking> getComparator() {
        Scanner sc = new Scanner(System.in);

        System.out.printf("How to sort bookings?%n 1.By booking number;%n 2.By price;%n 3.By room type;%n 4.By start;%n 5.By end;%n other number - exit.%n");

        int way = sc.nextInt();
        return switch (way) {
            case 1 -> new CompareByBookingNumber();
            case 2 -> new CompareByBookingPrice();
            case 3 -> new CompareBookingByRoomType();
            case 4 -> new CompareBookingByDateStart();
            case 5 -> new CompareBookingByDateEnd();
            default -> null;
        };
    }
}
