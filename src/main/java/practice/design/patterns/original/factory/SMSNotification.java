package practice.design.patterns.original.factory;

public class SMSNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("This is a sms notification!");
    }
}
