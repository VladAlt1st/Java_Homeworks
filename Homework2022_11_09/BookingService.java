package Homework2022_11_09;

import Homework2022_11_09.Camparators.BookingComparatorByScanner;
import Homework2022_11_09.Camparators.BookingComparatorFactory;

import java.util.Comparator;
import java.util.Scanner;

public class BookingService {
    private BookingsList bookingsList = new BookingsList();

    public BookingsList getBookingsList() {
        return bookingsList;
    }

    public void bookingServiceReception() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to make a booking? Yes - 1, no - other number.");
        if(sc.nextInt() == 1) {
            System.out.println("How many bookings?");
            int howMany = sc.nextInt();
            System.out.println(HotelRooms.getRoomsInfo());
            for (int i = 0; i < howMany; i++) {
                makeBooking();
            }
        }

        System.out.println("Would you like to sort bookings? Yes - 1, no - other number.");
        if(sc.nextInt() == 1) {
            BookingComparatorFactory bookingComparatorFactory = new BookingComparatorByScanner();
            Comparator<Booking> comparator = bookingComparatorFactory.getComparator();
            while (comparator != null) {
                BookingsList newBookingsList = new BookingsList(bookingsList.getSortedList(comparator));
                System.out.println(newBookingsList.getBookingsInfo());
                comparator = bookingComparatorFactory.getComparator();
            }
        }

        System.out.println("Want to delete the booking? Yes - 1, no - other number.");
        if(sc.nextInt() == 1) {
            System.out.println(bookingsList.getBookingsInfo());
            System.out.println("Enter the booking number to delete.");
            bookingsList.removeBooking(sc.nextInt());
        }

        System.out.println(bookingsList.getBookingsInfo());
        System.out.println("Want to continue session? Yes - 1, no - other number.");
        if(sc.nextInt() == 1) {
            bookingServiceReception();
        }
    }

    private void makeBooking() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter room number:");
        int roomNumber = sc.nextInt();
        System.out.println("Enter from: day, month, year;");
        int dayFrom = sc.nextInt();
        int monthFrom = sc.nextInt();
        int yearFrom = sc.nextInt();
        System.out.println("Enter to: day, month, year;");
        int dayTo = sc.nextInt();
        int monthTo = sc.nextInt();
        int yearTo = sc.nextInt();
        System.out.println("Fitness center pass? Yes - 1, no other number.");
        boolean pass = false;
        if(sc.nextInt() == 1) {
            pass = true;
        }
        bookingsList.addBooking(roomNumber, new DateTime(dayFrom, monthFrom, yearFrom), new DateTime(dayTo, monthTo, yearTo),new FitnessCenter(pass));
    }
}
