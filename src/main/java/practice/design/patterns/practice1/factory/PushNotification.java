package practice.design.patterns.practice1.factory;

public class PushNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("This is a push notification!");
    }
}
