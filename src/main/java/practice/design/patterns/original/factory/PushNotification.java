package practice.design.patterns.original.factory;

public class PushNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("This is a push notification!");
    }
}
