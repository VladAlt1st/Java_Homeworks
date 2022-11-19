package Homework2022_11_09;

import Homework2022_11_09.Rooms.*;

public class HotelRooms {

    private static final HotelRoom[] roomsList = {
            new StandardRoom(0,100,"(D)Standard"), new StandardRoom(1,100,"(D)Standard"), new StandardRoom(2,100,"(D)Standard"), new StandardRoom(3,100,"(D)Standard"),
            new SuperiorRoom(4,200,"(C)Superior"), new SuperiorRoom(5,200,"(C)Superior"), new SuperiorRoom(6, 200,"(C)Superior"),
            new DeluxeRoom(7,350,"(B)Deluxe"), new DeluxeRoom(8, 350,"(B)Deluxe"),
            new PresidentRoom(9,500,"(A)President")
    };

    public static HotelRoom[] getList() {
        return roomsList;
    }

    public static String getRoomsInfo() {
        StringBuilder res = new StringBuilder();
        for (HotelRoom room : roomsList) {
            res.append(room.toString()).append(System.lineSeparator());
        }
        return res.toString();
    }
}
