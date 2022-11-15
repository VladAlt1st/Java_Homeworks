package Homework2022_11_09;


public class DateTime {
    private int day;
    private int month;
    private int year;
    private int hour;
    private int min;

    public DateTime(int day, int month, int year, int hour, int min) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.min = min;
    }

    @Override
    public String toString() {
        return String.format("%d:%d %d-%d-%d", hour, min, day, month, year);
    }
}

