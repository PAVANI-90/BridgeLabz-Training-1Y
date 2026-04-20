package com.gla.StreamAPI.StreamapiStatement.forEachMethod;
import java.util.Arrays;
import java.util.List;
public class EmailNotifications {
    public static void main(String[] args) {

        List<String> emails = Arrays.asList(
                "user1@example.com",
                "user2@example.com",
                "user3@example.com"
        );


        emails.forEach(email -> sendEmailNotification(email));

    }


    private static void sendEmailNotification(String email) {
        System.out.println("Sending notification email to: " + email);

    }
}
