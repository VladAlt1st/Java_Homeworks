package Homework2022_11_09;

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
            for (int i = 0; i < howMany; i++) {
                makeBooking();
            }
        }

        System.out.println("Would you like to sort bookings? Yes - 1, no - other number.");
        if(sc.nextInt() == 1) {
            System.out.println("How to sort bookings?\n 1.By booking number;\n 2.By price;\n 3.By room type;\n 4.By start;\n 5.By end;");
            int way = sc.nextInt();
            sortBy(way);
            System.out.println(bookingsList.getBookingsInfo());
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
        HotelRooms.getRoomsInfo();
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

    private void sortBy(int way) {
        switch (way) {
            case 1 -> bookingsList.sortByBookingNumber();
            case 2 -> bookingsList.sortByBookingPrice();
            case 3 -> bookingsList.sortByRoomType();
            case 4 -> bookingsList.sortByDateStart();
            case 5 -> bookingsList.sortByDateEnd();
        }
    }
}
