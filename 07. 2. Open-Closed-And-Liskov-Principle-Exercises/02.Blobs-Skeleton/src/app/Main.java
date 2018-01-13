package app;

import app.engine.Engine;
import app.interfaces.InputReader;
import app.interfaces.OutputWriter;

import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.repositories.BlobRepository;
import app.repositories.Repository;

public class Main {
    public static void main(String[] args) {

        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        Repository repository = new BlobRepository();
        Runnable engine = new Engine(reader, writer, repository);

        engine.run();
    }
}
