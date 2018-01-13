package pr05_BarracksWars_Return_of_the_Dependencies;


import pr05_BarracksWars_Return_of_the_Dependencies.contracts.CommandInterpreter;
import pr05_BarracksWars_Return_of_the_Dependencies.contracts.Repository;
import pr05_BarracksWars_Return_of_the_Dependencies.contracts.UnitFactory;
import pr05_BarracksWars_Return_of_the_Dependencies.core.Engine;
import pr05_BarracksWars_Return_of_the_Dependencies.core.factories.UnitFactoryImpl;
import pr05_BarracksWars_Return_of_the_Dependencies.data.UnitRepository;
import pr05_BarracksWars_Return_of_the_Dependencies.interpreters.CommandInterpreterImpl;

public class Main {
    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        CommandInterpreter interpreter = new CommandInterpreterImpl();
        Runnable engine = new Engine(repository, unitFactory, interpreter);
        engine.run();
    }
}
