package com.interview.systemDesign.DesignPattern.creational;

// The factory design pattern says that define an interface ( A java interface or an abstract class) for creating object
// and let the subclasses decide which class to instantiate.

public class FactoryPattern {

    public static void main() {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.createNotification("SMS");
        notification.notifyUser();
    }
}

class NotificationFactory {
    public Notification createNotification(String channel) {
        if (channel == null || channel.isEmpty())
            return null;

        switch (channel) {
            case "SMS":
                return new SMSNotification();
            case "EMAIL":
                return new EmailNotification();
            case "PUSH":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown channel "+channel);
        }
    }
}

interface Notification {
    void notifyUser();
}

class SMSNotification implements Notification {

    @Override
    public void notifyUser() {
        System.out.println("Sending an SMS notification");
    }
}

class EmailNotification implements Notification {

    @Override
    public void notifyUser() {
        System.out.println("Sending an e-mail notification");
    }
}

class PushNotification implements Notification {

    @Override
    public void notifyUser() {
        System.out.println("Sending a push notification");
    }
}
