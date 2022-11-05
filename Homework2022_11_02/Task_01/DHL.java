package Homework2022_11_02.Task_01;

public class DHL implements MailDeliveryService {

    @Override
    public void sendMail() {
        System.out.println("\"Put the letter in an envelope, put a stamp, send\".");
    }
}
