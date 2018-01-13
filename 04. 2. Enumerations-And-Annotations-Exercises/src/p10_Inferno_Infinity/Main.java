package p10_Inferno_Infinity;

import p10_Inferno_Infinity.controller.WeaponsManager;
import p10_Inferno_Infinity.engine.Engine;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        WeaponsManager weaponsManager = new WeaponsManager();
        Engine engine = new Engine(weaponsManager);

        engine.run();
    }
}
