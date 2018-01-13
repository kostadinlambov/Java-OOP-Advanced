package p14_Refactoring_Bonus;


import p14_Refactoring_Bonus.controller.WeaponsManager;
import p14_Refactoring_Bonus.engine.Engine;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        WeaponsManager weaponsManager = new WeaponsManager();
        Engine engine = new Engine(weaponsManager);
        engine.run();
    }
}
