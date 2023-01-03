package practice.design.patterns.practice1.factory;

public class EmailNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("This is an email notification!");
    }
}
