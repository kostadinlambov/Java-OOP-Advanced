package p04_Work_Force;


import p04_Work_Force.engine.Engine;
import p04_Work_Force.interfaces.InputReader;
import p04_Work_Force.interfaces.OutputWriter;
import p04_Work_Force.interpreters.CommandInterpreterImpl;
import p04_Work_Force.io.ConsoleInputReader;
import p04_Work_Force.io.ConsoleOutputWriter;
import p04_Work_Force.repositories.JobRepository;
import p04_Work_Force.repositories.Repository;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        Repository repository = new JobRepository();
        CommandInterpreterImpl interpreter = new CommandInterpreterImpl();
        Runnable engine = new Engine(reader, writer, repository, interpreter );
        engine.run();
    }
}
