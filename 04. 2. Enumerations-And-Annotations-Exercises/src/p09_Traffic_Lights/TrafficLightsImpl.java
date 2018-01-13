package p09_Traffic_Lights;

import java.util.Iterator;

public class TrafficLightsImpl implements Iterator<TrafficLights_Enum> {

    private TrafficLights_Enum currentLight;

    public TrafficLightsImpl(TrafficLights_Enum currentLight) {
        this.currentLight = currentLight;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public TrafficLights_Enum next() {
        switch (this.currentLight.name()){
            case "RED":
                this.currentLight = TrafficLights_Enum.valueOf("GREEN");
                break;
            case "GREEN":
                this.currentLight = TrafficLights_Enum.valueOf("YELLOW");
                break;
            case "YELLOW":
                this.currentLight = TrafficLights_Enum.valueOf("RED");
                break;
        }
        return this.currentLight;
    }
}
