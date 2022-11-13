package Homework2022_11_09;

/*It is necessary to write an application for recording data on booking rooms in hotels.
  Your program should have several types of rooms, for example: standard, superior, deluxe, president.
  Naturally, the room is the price of living. In addition, the suites, the president has access to the fitness center,
  for other categories of rooms, access to the fitness center is paid as a separate service.
  Your program allows you to select a hotel reservation and view reservation details, cancel a reservation, view all reservations.

  Booking data, if you want, can be set in the program as a constant or entered through Scanner

  To reflect booking dates, you must use the previously written MyDate class (in this task, we do not use standard Java classes for working with dates).
  As additional tasks: in the MyDate class, implement the following methods:
  - counting the number of days in a given date range
  -determining the intersection of intervals*/

public class Main {
    public static void main(String[] args) {
        BookingService bookingService = new BookingService();
        bookingService.addBooking();
    }
}
