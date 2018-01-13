package p05_Kings_Gambit_Extended;

import p05_Kings_Gambit_Extended.engine.Engine;
import p05_Kings_Gambit_Extended.interfaces.OutputWriter;
import p05_Kings_Gambit_Extended.io.ConsoleOutputWriter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException,
            IOException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {

        //  InputReader reader = new ConsoleInputreader();
        OutputWriter writer = new ConsoleOutputWriter();
        // Repository repository = new HeroRepository();
        Runnable engine = new Engine(writer);
        engine.run();
    }
}

