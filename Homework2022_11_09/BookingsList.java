package Homework2022_11_09;

import java.util.ArrayList;

public class BookingsList {

    private ArrayList<Booking> bookingsList = new ArrayList<>();
    private HotelRoom[] roomsList = HotelRooms.getList();

    public void addBooking(int roomNumber, DateTime from, DateTime to, FitnessCenter fitnessCenter) {
        bookingsList.add(new Booking(roomsList[roomNumber-1], from, to, fitnessCenter));
    }

    public void removeBooking(int number) {
        for (int i = 0; i < bookingsList.size(); i++) {
            if(bookingsList.indexOf(bookingsList.get(i)) == (number - 1)) {
                bookingsList.remove(i);
                i--;
            }
        }
    }

    public String getBookingsInfo() {
        StringBuilder str = new StringBuilder();
        for(Booking booking:bookingsList) {
            str.append("Booking ").append(bookingsList.indexOf(booking) + 1).append(": ").append(System.lineSeparator());
            str.append(booking.toString()).append(System.lineSeparator());
        }
        return str.toString();
    }
}
