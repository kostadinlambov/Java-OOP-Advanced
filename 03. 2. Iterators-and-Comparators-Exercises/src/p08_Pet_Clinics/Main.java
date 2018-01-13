package p08_Pet_Clinics;


import p08_Pet_Clinics.core.ClinicManager;
import p08_Pet_Clinics.engines.Engine;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        ClinicManager clinicManager = new ClinicManager();
        Engine engine = new Engine(clinicManager);

        engine.run();
    }
}
