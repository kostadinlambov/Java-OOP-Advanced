package app;

import app.contracts.*;
import app.controllers.BattlefieldImpl;
import app.engine.GameEngine;
import app.factory.ActionFactoryImpl;
import app.factory.SpecialFactoryImpl;
import app.factory.TargetableFactoryImpl;
import app.handlers.CommandHandlerImpl;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IOException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();

        ActionFactory actionFactory = new ActionFactoryImpl();
        TargetableFactory targetableFactory = new TargetableFactoryImpl();
        SpecialFactory specialFactory = new SpecialFactoryImpl();

        Battlefield battleField = new BattlefieldImpl(actionFactory, targetableFactory, specialFactory, writer);
        CommandHandler handler = new CommandHandlerImpl(battleField);

        Engine engine = new GameEngine(reader, handler);
        engine.run();
    }
}
