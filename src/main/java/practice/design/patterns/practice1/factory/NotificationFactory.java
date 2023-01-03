package practice.design.patterns.practice1.factory;

import org.apache.commons.lang3.StringUtils;

public class NotificationFactory {
    public static Notification createNotification(String channel){
        if(StringUtils.isBlank(channel)){
            throw new IllegalArgumentException("Channel "+channel+"cannot be blank!");
        }
        switch (channel){
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
