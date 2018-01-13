package p02_services;

public class SmsNotificationService implements NotificationService {

    @Override
    public void sendNotification() {
        System.out.println("Sms send");
    }

    @Override
    public boolean isActive() {
        return false;
    }
}
