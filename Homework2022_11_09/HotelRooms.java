package Homework2022_11_09;

public class HotelRooms {

    private static final HotelRoom[] listOfRooms = {
            new StandardRoom(1,100,new FitnessCenter(false)), new StandardRoom(2,100,new FitnessCenter(false)),
            new StandardRoom(3,100,new FitnessCenter(false)), new StandardRoom(4,100,new FitnessCenter(false)),
            new SuperiorRoom(5,200,new FitnessCenter(false)), new SuperiorRoom(6,200,new FitnessCenter(false)),
            new SuperiorRoom(7, 200,new FitnessCenter(false)),
            new DeluxeRoom(8,350), new DeluxeRoom(9, 350),
            new PresidentRoom(10,500)
    };

    public static HotelRoom[] getList() {
        return listOfRooms;
    }

    public static String getStatus() {
        StringBuilder res = new StringBuilder();
        for (HotelRoom listOfRoom : listOfRooms) {
            res.append(listOfRoom.toString()).append(System.lineSeparator());
        }
        return res.toString();
    }
}
