package Homework2022_11_09;

public class HotelRooms {

    private static final HotelRoom[] roomsList = {
            new StandardRoom(1,100), new StandardRoom(2,100), new StandardRoom(3,100), new StandardRoom(4,100),
            new SuperiorRoom(5,200), new SuperiorRoom(6,200), new SuperiorRoom(7, 200),
            new DeluxeRoom(8,350), new DeluxeRoom(9, 350),
            new PresidentRoom(10,500)
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
