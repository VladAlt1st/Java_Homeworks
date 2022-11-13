package Homework2022_11_09;

import java.util.ArrayList;

public class Booking {

    private ArrayList<HotelRoom> booking = new ArrayList<>();
    private HotelRoom[] listOfRooms = HotelRooms.getList();

    public void addRoom(int roomNumber) {
        if(listOfRooms[roomNumber - 1].isStatus()) {
            listOfRooms[roomNumber - 1].setStatus(false);
            booking.add(listOfRooms[roomNumber - 1]);
        }
    }

    public void deleteRoom(int index) {
        int roomNumber = booking.get(index).getNumberOfRoom() - 1;
        if(index < booking.size()) {
            listOfRooms[roomNumber].setStatus(true);
            listOfRooms[roomNumber].getFitnessCenterPass().setAvailable(false);
            booking.remove(index);
        }
    }

    public String checkout() {
        StringBuilder res = new StringBuilder();
        for(HotelRoom room: booking) {
            res.append(room.toString());
            if(room.getFitnessCenterPass() != null) {
                if (room.getFitnessCenterPass().isAvailable()){
                    res.append("; with fitness center +").append(room.getFitnessCenterPass().getPrice());
                }
            }
            res.append(System.lineSeparator());
        }
        res.append("Total: ").append(getTotal()).append(System.lineSeparator());
        return res.toString();
    }

    public double getTotal() {
        double total = 0;
        for(HotelRoom room: booking) {
            total += room.getPrice();
            if(room.getFitnessCenterPass() != null) {
                if (room.getFitnessCenterPass().isAvailable()){
                    total += room.getFitnessCenterPass().getPrice();
                }
            }
        }
        return total;
    }

    public void addFitnessPass() {
        for(HotelRoom room: booking) {
            if(room.getFitnessCenterPass() != null) {
                room.getFitnessCenterPass().setAvailable(true);
            }
        }
    }
}
