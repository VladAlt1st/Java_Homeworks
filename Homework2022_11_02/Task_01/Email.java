package Homework2022_11_02.Task_01;

public class Email implements MailDeliveryService {

    @Override
    public void sendMail() {
        System.out.println("\"Send over the Internet\".");
    }
}
