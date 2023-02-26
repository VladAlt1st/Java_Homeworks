package Homework2023_02_22;

import java.time.*;
import java.util.List;

public class DateHW {
    public static void main(String[] args) {
        ZonedDateTime from = ZonedDateTime.of(LocalDateTime.of(2023,2,26,15,5), ZoneId.of("America/Los_Angeles"));
        ZonedDateTime to = task2(ZoneId.of("CET"), from, Duration.ofMinutes(650));
        System.out.println(to);
    }

    public static void task1() {
        //Составить список времен начала всех занятий по Java на февраль,
        //если предположить, что они проходят каждый понедельник/среду c 9:30 CET.
        LocalDate start = LocalDate.of(2023,2,1);
        List<ZonedDateTime> list = start.datesUntil(start.plusMonths(1), Period.ofDays(1))
                .filter(localDate -> localDate.getDayOfWeek().getValue() == 1 || localDate.getDayOfWeek().getValue() == 3)
                .map(localDate -> ZonedDateTime.of(localDate, LocalTime.of(9, 30), ZoneId.of("CET")))
                .toList();
        System.out.println(list);
    }

    public static ZonedDateTime task2(ZoneId to, ZonedDateTime from, Duration duration) {
        //Рейс из Лос-Анджелеса во Франкфурт отправляется в 15:05 по местному времени
        // и длится 10 ч. 50 м. Во сколько он прилетит? Написать метод, который мог бы совершать подобные вычисления.
        return from.plusMinutes(duration.toMinutes()).withZoneSameInstant(to);
    }
}
