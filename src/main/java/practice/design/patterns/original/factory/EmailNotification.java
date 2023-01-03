package practice.design.patterns.original.factory;

public class EmailNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("This is an email notification!");
    }
}
