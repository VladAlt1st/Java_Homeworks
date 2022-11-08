package Homework2022_11_02.Task_01;

public class MailSender {

    MailDeliveryService mailDeliveryService;

    public MailSender(MailDeliveryService mailDeliveryService) {
        this.mailDeliveryService = mailDeliveryService;
    }

    void send() {
        mailDeliveryService.sendMail();
    }
}
