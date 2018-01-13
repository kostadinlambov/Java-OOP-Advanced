package p09_Traffic_Lights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<TrafficLightsImpl> trafficLightsList = new ArrayList<>();

        String[] inputLine = reader.readLine().split("\\s+");

        for (String string : inputLine) {
            TrafficLights_Enum  currentLight = TrafficLights_Enum.valueOf(string.toUpperCase());
            TrafficLightsImpl  trafficLight = new TrafficLightsImpl(currentLight);
            trafficLightsList.add(trafficLight);
        }

        int number = Integer.parseInt(reader.readLine());

        for (int i = 0; i < number; i++) {
            StringBuilder sb = new StringBuilder();
            for (TrafficLightsImpl lights : trafficLightsList) {
                sb.append(lights.next()).append(" ");
            }
            System.out.println(sb.toString().trim());

        }
    }
}
