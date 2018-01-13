package p02_services;

public class OnlineStoreOrder {

    private NotificationService emailNotification;
    private NotificationService smsNotification;

    public OnlineStoreOrder(NotificationService emai, NotificationService sms) {
        this.emailNotification = emai;
        this.smsNotification = sms;
    }

    public void process() {
        if (this.smsNotification.isActive())
            this.smsNotification.sendNotification();

        if (this.emailNotification.isActive())
            this.smsNotification.sendNotification();
    }

    public static void main(String[] args) {
        NotificationService email = new EmailNotificationService(true);
        NotificationService sms = new SmsNotificationService();
        OnlineStoreOrder onlineStoreOrder = new OnlineStoreOrder(email, sms);
        onlineStoreOrder.process();
    }
}
