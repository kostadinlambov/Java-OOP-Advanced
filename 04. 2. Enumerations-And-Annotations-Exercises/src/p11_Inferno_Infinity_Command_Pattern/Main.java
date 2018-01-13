package p11_Inferno_Infinity_Command_Pattern;

import p11_Inferno_Infinity_Command_Pattern.io.ConsoleInputReader;
import p11_Inferno_Infinity_Command_Pattern.io.ConsoleOutputWriter;
import p11_Inferno_Infinity_Command_Pattern.io.InputReader;
import p11_Inferno_Infinity_Command_Pattern.io.OutputWriter;
import p11_Inferno_Infinity_Command_Pattern.models.api.WeaponInterface;
import p11_Inferno_Infinity_Command_Pattern.engine.Engine;
import p11_Inferno_Infinity_Command_Pattern.repositories.Repository;
import p11_Inferno_Infinity_Command_Pattern.repositories.WeaponRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        InputReader reader = new ConsoleInputReader(bufferedReader);
        OutputWriter writer = new ConsoleOutputWriter();
        Repository<WeaponInterface> weaponRepository = new WeaponRepository<>();
        Runnable engine = new Engine(weaponRepository, reader, writer);

        engine.run();
    }
}
