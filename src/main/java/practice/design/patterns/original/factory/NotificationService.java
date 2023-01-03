package practice.design.patterns.original.factory;

public class NotificationService {
    public static void main(String[] args) {
        NotificationFactory.createNotification("EMAIL").notifyUser();
        NotificationFactory.createNotification("SMS").notifyUser();
        NotificationFactory.createNotification("PUSH").notifyUser();
    }
}
