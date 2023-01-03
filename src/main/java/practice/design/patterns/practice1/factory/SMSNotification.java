package practice.design.patterns.practice1.factory;

public class SMSNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("This is a sms notification!");
    }
}
