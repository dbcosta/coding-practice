package practice.design.patterns.original.factory;

import org.apache.commons.lang3.StringUtils;

public class NotificationFactory {
    public static Notification createNotification(String channel){
        if(StringUtils.isBlank(channel)){
            throw new IllegalArgumentException("Channel cannot be blank, empty or null!");
        }
        switch(channel){
            case "EMAIL":
                return new EmailNotification();
            case "SMS":
                return new SMSNotification();
            case "PUSH":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown channel: "+channel);
        }
    }
}
