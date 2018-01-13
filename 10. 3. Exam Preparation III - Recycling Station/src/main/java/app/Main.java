package app;

import app.waste_disposal.DefaultGarbageProcessor;
import app.waste_disposal.DefaultStrategyHolder;
import app.waste_disposal.contracts.*;
import app.waste_disposal.core.Engine;
import app.waste_disposal.core.WasteManager;
import app.waste_disposal.io.ConsoleInputReader;
import app.waste_disposal.io.ConsoleOutputWriter;


public class Main {
    public static void main(String[] args) {

        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();

        StrategyHolder strategyHolder = new DefaultStrategyHolder();
        GarbageProcessor garbageProcessor = new DefaultGarbageProcessor(strategyHolder);
        WasteManager wasteManager = new WasteManager(garbageProcessor);

        Runnable engine = new Engine(reader, writer, wasteManager, garbageProcessor);

        engine.run();
    }
}
