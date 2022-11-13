package Homework2022_11_09;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class BookingService {

    private ArrayList<Booking> bookingList = new ArrayList<>();

    public void addBooking() {
        Booking booking = new Booking();
        System.out.println(HotelRooms.getStatus());
        System.out.println("Select available room or another number to exit.");
        Scanner sc = new Scanner(System.in);
        int roomNumber = sc.nextInt();
        if(roomNumber > 0 && roomNumber <= HotelRooms.getList().length) {
            booking.addRoom(roomNumber);
        }
        if(HotelRooms.getList()[roomNumber].getFitnessCenterPass() != null) {
            System.out.println("With Fitness-pass? Yes - 1; No - other number.");
            int choose = sc.nextInt();
            if(choose == 1) {
                booking.addFitnessPass();
            }
        }
        bookingList.add(booking);
        System.out.println(listCheckout());
        System.out.println("Would you like to add another room? Yes - 1; No - other number.");
        int choose = sc.nextInt();
        if(choose == 1) {
            addBooking();
        }
    }

    public String listCheckout() {
        StringBuilder res = new StringBuilder();
        for(Booking booking:bookingList) {
            res.append(booking.checkout()).append(System.lineSeparator());
        }
        res.append("--------------").append(System.lineSeparator());
        return res.toString();
    }
}
