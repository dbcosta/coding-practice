package practice.design.patterns.practice1.factory;

public class NotificationService {
    public static void main(String[] args) {
        NotificationFactory.createNotification("EMAIL").notifyUser();
        NotificationFactory.createNotification("SMS").notifyUser();
        NotificationFactory.createNotification("PUSH").notifyUser();
    }
}
