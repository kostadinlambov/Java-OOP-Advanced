package p08_Pet_Clinics.engines;

import p08_Pet_Clinics.core.ClinicManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {

    private ClinicManager clinicManager;

    public Engine(ClinicManager clinicManager) {
        this.clinicManager = clinicManager;
    }


    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfCommands = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfCommands; i++) {

            String[] tokens = reader.readLine().split("\\s+");

            String command = tokens[0];

            try {
                switch (command) {
                    case "Create":
                        if ("Pet".equalsIgnoreCase(tokens[1])) {
                            String name = tokens[2];
                            int age = Integer.parseInt(tokens[3]);
                            String kind = tokens[4];
                            clinicManager.createPet(name, age, kind);
                        } else {
                            String name = tokens[2];
                            int numberOfRooms = Integer.parseInt(tokens[3]);
                            clinicManager.createClinic(name, numberOfRooms);
                        }
                        break;
                    case "Add":
                        String petName = tokens[1];
                        String clinicName = tokens[2];
                        System.out.println(clinicManager.add(petName, clinicName));
                        break;
                    case "Release":
                        clinicName = tokens[1];
                        System.out.println(clinicManager.release(clinicName));
                        break;
                    case "HasEmptyRooms":
                        clinicName = tokens[1];
                        System.out.println(clinicManager.hasEmptyRooms(clinicName));
                        break;
                    case "Print":
                        clinicName = tokens[1];
                        if (tokens.length == 2) {
                            clinicManager.print(clinicName);
                        } else {
                            int roomNumber = Integer.parseInt(tokens[2]);
                            clinicManager.print(clinicName, roomNumber);
                        }
                        break;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }
}