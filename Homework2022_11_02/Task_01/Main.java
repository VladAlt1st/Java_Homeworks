package Homework2022_11_02.Task_01;

public class Main {
    public static void main(String[] args) {
        ScannerMailSenderFactory scannerMailSenderFactory = new ScannerMailSenderFactory();
        MailSender mailSender = scannerMailSenderFactory.getSender();
        mailSender.send();
    }
}
