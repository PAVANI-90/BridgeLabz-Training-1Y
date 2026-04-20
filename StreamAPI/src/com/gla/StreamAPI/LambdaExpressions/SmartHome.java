package com.gla.StreamAPI.LambdaExpressions;
@FunctionalInterface
interface LightAction {
    void activate(String room);
}
public class SmartHome {
    public static void trigger(LightAction action, String trigger) {
        System.out.println("Trigger: " + trigger);
        action.activate("room");
    }

    public static void main(String[] args) {

        trigger((room) -> System.out.println(room + " lights ON full brightness"), "motion");

        trigger((room) -> System.out.println(room + " lights dim to 30%"), "evening");

        trigger((room) -> System.out.println(room + " lights pulse colors"), "party voice");
    }
}
