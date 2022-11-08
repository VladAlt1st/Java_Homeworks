package Homework2022_11_02.Task_01;

import java.util.Scanner;

public class ScannerMailSenderFactory {

    public MailSender getSender(){
        System.out.println("Choose a shipping method:\n" +
                "1. by DHL;\n" +
                "2. by Email;\n" +
                "3. by Pigeon.");
        return switch (setChoice()) {
            case 1 -> new MailSender(new DHL());
            case 2 -> new MailSender(new Email());
            case 3 -> new MailSender(new Pigeon());
            default -> null;
        };
    }

    private int setChoice() {
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        while (choice < 1 || choice > 3) {
            choice = sc.nextInt();
        }
        return choice;
    }
}
