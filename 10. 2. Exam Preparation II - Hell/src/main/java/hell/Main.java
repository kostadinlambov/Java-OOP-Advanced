package hell;

import hell.engine.Engine;

import hell.interfaces.InputReader;
import hell.interfaces.OutputWriter;
import hell.io.ConsoleInputReader;
import hell.io.ConsoleOutputWriter;
import hell.repositories.HeroRepository;
import hell.repositories.Repository;


public class Main {
    public static void main(String[] args) {

        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        Repository repository = new HeroRepository();
        Runnable engine = new Engine(reader, writer, repository);

        engine.run();
    }
}