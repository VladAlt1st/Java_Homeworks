package Homework2022_11_09;

import Homework2022_11_09.Camparators.*;
import Homework2022_11_09.Rooms.HotelRoom;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookingsList {

    private List<Booking> bookingsList = new ArrayList<>();
    private HotelRoom[] roomsList = HotelRooms.getList();
    private int bookingNumber = 1;

    public BookingsList(List<Booking> bookingsList) {
        this.bookingsList = bookingsList;
    }

    public BookingsList() {}

    public void addBooking(int roomNumber, DateTime from, DateTime to, FitnessCenter fitnessCenter) {
        bookingsList.add(new Booking(roomsList[roomNumber], from, to, fitnessCenter, bookingNumber));
        bookingNumber++;
    }

    public void removeBooking(int bookingNumber) {
        for(Booking booking:bookingsList) {
            if(booking.getBookingNumber() == bookingNumber) {
                bookingsList.remove(booking);
                break;
            }
        }
    }

    public void sortList(Comparator<Booking> comparator) {
        bookingsList.sort(comparator);
    }

    public List<Booking> getSortedList(Comparator<Booking> comparator) {
        List<Booking> newBookingList = new ArrayList<>(bookingsList);
        newBookingList.sort(comparator);
        return newBookingList;
    }

    public String getBookingsInfo() {
        StringBuilder str = new StringBuilder();
        for(Booking booking:bookingsList) {
            str.append(booking.toString()).append(System.lineSeparator());
        }
        return str.toString();
    }
}
