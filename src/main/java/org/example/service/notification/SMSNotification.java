package org.example.service.notification;

public class SMSNotification implements NotificationService {
    public void notifyUser(String message) {
        System.out.println("SMS: " + message);
    }
}
