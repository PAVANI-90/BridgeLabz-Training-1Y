package com.gla.WrapperClass.ScenarioBased;
import java.util.ArrayList;
public class SensorDataLogger {
    public static void logTemperature(double temp) {

        temperatures.add(temp);
    }


    private static ArrayList<Double> temperatures = new ArrayList<>();
    public static void main(String[] args){
        logTemperature(23.5);
        logTemperature(25.1);
        logTemperature(22.8);

        double avgTemp = 0;
        for (Double temp : temperatures) {
            avgTemp += temp;
        }
        avgTemp /= temperatures.size();
        Double cachedTemp = 24.0;
        logTemperature(cachedTemp.doubleValue());

        System.out.println("Logged temperatures: " + temperatures);
        System.out.println("Average: " + avgTemp + "°C");
    }
}
