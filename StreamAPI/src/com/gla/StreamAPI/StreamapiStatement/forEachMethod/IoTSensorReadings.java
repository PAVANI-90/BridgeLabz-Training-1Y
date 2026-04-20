package com.gla.StreamAPI.StreamapiStatement.forEachMethod;
import java.util.Arrays;
import java.util.List;
public class IoTSensorReadings {
    public static void main(String[] args) {


        List<Double> readings = Arrays.asList(
                18.5, 21.0, 27.3, 30.1, 16.8, 29.9, 33.5
        );

        double threshold = 25.0;

        System.out.println("Sensor readings above threshold (" + threshold + "):");

        readings.stream()
                .filter(value -> value > threshold)
                .forEach(value ->
                        System.out.println("ALERT: Reading = " + value)
                );
    }
}
