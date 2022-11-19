package Homework2022_11_09;


public class DateTime implements Comparable<DateTime> {
    private int day;
    private int month;
    private int year;

    public DateTime(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%d-%d-%d",day, month, year);
    }

    public static int daysBetween(DateTime from, DateTime to) {
        return to.getDays() - from.getDays();
    }

    private int getDays() {
        int days = 0;
        for (int i = 2000; i < year; i++) {
            days += isLeapYear() ? 366 : 365;
        }
        for (int i = 0; i < month; i++) {
            days += getDaysInMonth();
        }
        days += day;
        return days;
    }

    private int getDaysInMonth() {
        return switch (month) {
            case 2 -> isLeapYear() ? 29 : 28;
            case 4, 6, 9, 11 -> 30;
            default -> 31;
        };
    }

    private boolean isLeapYear() {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }

    @Override
    public int compareTo(DateTime o) {
        return this.getDays() - o.getDays();
    }
}

