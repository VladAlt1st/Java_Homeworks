package Homework2022_11_02.Task_01;

import java.util.Scanner;

public class Sender {

    public static void dialogWindow() {
        System.out.println("Choose a shipping method:\n" +
                "1. by DHL;\n" +
                "2. by Email;\n" +
                "3. by Pigeon;\n" +
                "another digit - exit.");
        Scanner sc = new Scanner(System.in);
        setShippingMethod(sc.nextInt());
    }

    private static void setShippingMethod(int method) {
        switch (method) {
            case 1 -> send(new DHL());
            case 2 -> send(new Email());
            case 3 -> send(new Pigeon());
        }
    }

    private static void send(MailDeliveryService mailDeliveryService) {
        mailDeliveryService.sendMail();
    }
}
