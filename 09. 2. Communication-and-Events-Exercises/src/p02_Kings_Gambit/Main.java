package p02_Kings_Gambit;

import p02_Kings_Gambit.engine.Engine;
import p02_Kings_Gambit.interfaces.*;
import p02_Kings_Gambit.io.ConsoleOutputWriter;

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

