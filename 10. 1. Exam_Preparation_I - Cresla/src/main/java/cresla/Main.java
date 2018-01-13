package cresla;


import cresla.engine.Engine;
import cresla.engine.ReactorManager;
import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;
import cresla.io.ConsoleInputReader;
import cresla.io.ConsoleOutputWriter;

public class Main {
    public static void main(String[] args) {

        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        Manager manager = new ReactorManager();
        Runnable engine = new Engine(reader, writer, manager);
        engine.run();


    }
}
