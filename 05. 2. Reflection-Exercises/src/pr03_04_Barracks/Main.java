package pr03_04_Barracks;

import pr03_04_Barracks.contracts.CommandInterpreter;
import pr03_04_Barracks.contracts.Repository;
import pr03_04_Barracks.contracts.Runnable;
import pr03_04_Barracks.contracts.UnitFactory;
import pr03_04_Barracks.core.Engine;
import pr03_04_Barracks.core.factories.UnitFactoryImpl;
import pr03_04_Barracks.data.UnitRepository;
import pr03_04_Barracks.interpreters.CommandInterpreterImpl;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		CommandInterpreter interpreter = new CommandInterpreterImpl(repository, unitFactory);
		Runnable engine = new Engine(repository, unitFactory, interpreter);
		engine.run();
	}
}
