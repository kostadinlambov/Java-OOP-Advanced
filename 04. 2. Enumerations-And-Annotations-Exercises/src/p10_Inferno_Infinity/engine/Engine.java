package p10_Inferno_Infinity.engine;

import p10_Inferno_Infinity.controller.WeaponsManager;
import p10_Inferno_Infinity.entities.enumerations.WeaponType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private WeaponsManager weaponsManager;

    public Engine(WeaponsManager weaponsManager) {
        this.weaponsManager = weaponsManager;
    }

    public void run() throws IOException {
        while (true) {
            String[] tokens = reader.readLine().split(";");
            if ("END".equalsIgnoreCase(tokens[0])) {
                break;
            }

            String command = tokens[0];

            switch (command) {
                case "Create":
                    WeaponType weaponType = WeaponType.valueOf(tokens[1]);
                    String name = tokens[2];
                    weaponsManager.createWeapon(name, weaponType);
                    break;
                case "Add":
                    String weaponName = tokens[1];
                    int socketIndex = Integer.parseInt(tokens[2]);
                    String gemType = tokens[3];
                    weaponsManager.addGem(weaponName, socketIndex, gemType);
                    break;
                case "Remove":
                    weaponName = tokens[1];
                    socketIndex = Integer.parseInt(tokens[2]);
                    weaponsManager.removeGem(weaponName, socketIndex);
                    break;
                case "Print":
                    weaponName = tokens[1];
                    weaponsManager.print(weaponName);
                    break;
                case "Compare":
                    String firstWeaponName = tokens[1];
                    String secondWeaponName = tokens[2];
                    weaponsManager.compare(firstWeaponName, secondWeaponName);
                    break;
            }
        }
    }
}
