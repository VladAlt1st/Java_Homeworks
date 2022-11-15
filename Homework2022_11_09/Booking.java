package Homework2022_11_09;

public class Booking {

    private HotelRoom room;
    private DateTime from;
    private DateTime to;
    private FitnessCenter fitnessCenter;

    public Booking(HotelRoom room, DateTime from, DateTime to, FitnessCenter fitnessCenter) {
        this.room = room;
        this.from = from;
        this.to = to;
        this.fitnessCenter = fitnessCenter;
    }

    public DateTime getFrom() {
        return from;
    }

    public DateTime getTo() {
        return to;
    }

    public FitnessCenter getFitnessCenter() {
        return fitnessCenter;
    }

    @Override
    public String toString() {
        return String.format("%s;\n %s;\n From - %s to %s.",
                room.toString(),fitnessCenter.toString(),from.toString(),to.toString());
    }
}
