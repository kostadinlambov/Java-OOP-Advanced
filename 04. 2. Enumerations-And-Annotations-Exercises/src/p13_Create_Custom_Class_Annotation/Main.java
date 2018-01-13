package p13_Create_Custom_Class_Annotation;


import p13_Create_Custom_Class_Annotation.controller.WeaponsManager;
import p13_Create_Custom_Class_Annotation.engine.Engine;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        WeaponsManager weaponsManager = new WeaponsManager();
        Engine engine = new Engine(weaponsManager);
        engine.run();
    }
}
