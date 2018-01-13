package app.waste_disposal.core;

import app.waste_disposal.ProcessingDataImpl;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.InputReader;
import app.waste_disposal.contracts.OutputWriter;
import app.waste_disposal.contracts.ProcessingData;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Engine implements Runnable {

    private static final String TERMINATE_COMMAND = "TimeToRecycle";

    private List<String> params;
    InputReader reader;
    OutputWriter writer;
    WasteManager manager;


    public Engine(InputReader reader, OutputWriter writer, WasteManager wasteManager, GarbageProcessor garbageProcessor) {
        this.reader = reader;
        this.writer = writer;
        this.params = new ArrayList<>();
        this.manager = wasteManager;
    }

    @Override
    public void run() {

        while (true) {
            String[] commandArr = this.reader.readLine().split("\\s+");
            List<String> tokens = new ArrayList<>();
            if(commandArr.length > 1){
                 tokens = Arrays.asList(commandArr[1].split("\\|"));
            }

            try {
                this.dispatchCommand(commandArr[0], tokens);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }


            if (TERMINATE_COMMAND.equalsIgnoreCase(commandArr[0])) {
                break;
            }
        }
    }

    private void dispatchCommand(String command, List<String> tokens) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        this.params = tokens;

        switch (command) {
            case "ProcessGarbage":
                writer.writeLine(this.manager.processGarbage(this.params));
                break;
            case "Status":
                writer.writeLine(this.manager.status());
                break;
        }
    }


}
