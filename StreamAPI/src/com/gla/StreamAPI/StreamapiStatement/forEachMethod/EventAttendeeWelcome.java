package com.gla.StreamAPI.StreamapiStatement.forEachMethod;
import java.util.Arrays;
import java.util.List;
public class EventAttendeeWelcome {
    public static void main(String[] args) {

        List<String> attendees = Arrays.asList(
                "Aman",
                "Bhavya",
                "Chirag",
                "Diya",
                "Esha"
        );

        System.out.println("Sending welcome messages to attendees:\n");

        attendees.forEach(name ->
                System.out.println("Welcome to the event, " + name + "!")
        );
    }
}
