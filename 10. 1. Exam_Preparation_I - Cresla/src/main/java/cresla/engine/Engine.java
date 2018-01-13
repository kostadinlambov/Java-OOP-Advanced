package cresla.engine;

import cresla.SingleIdObject;
import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine implements Runnable {
    private static final String TERMINATE_COMMAND = "Exit";
    private static final String COMMAND_CLASS_PATH = "cresla.commands.";
    private static final String COMMAND_CLASS_NAME_SUFFIX = "Command";


    private List<String> params;
    private InputReader reader;
    private OutputWriter writer;
    private Manager reactorManager;


    public Engine(InputReader reader, OutputWriter writer, Manager manager) {
        this.reader = reader;
        this.writer = writer;
        this.reactorManager = manager;
    }

    @Override
    public void run() {
        //System.out.println(singleIdObject.getId());


        while (true) {
            List<String> tokens = new ArrayList<>(Arrays.asList(this.reader.readLine().split("\\s+")));

            try {
                this.dispatchCommand(tokens.get(0), tokens.stream().skip(1).collect(Collectors.toList()));
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }

            if (TERMINATE_COMMAND.equalsIgnoreCase(tokens.get(0))) {
                break;
            }
        }
    }

    private void dispatchCommand(String command, List<String> tokens) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        this.params = tokens;

        //Class<?> commandClass = Class.forName(COMMAND_CLASS_PATH + command + COMMAND_CLASS_NAME_SUFFIX);

        switch (command) {
            case "Reactor":
                writer.writeLine(this.reactorManager.reactorCommand(this.params));
                break;
            case "Module":
                writer.writeLine(this.reactorManager.moduleCommand(this.params));
                break;
            case "Report":
                writer.writeLine(this.reactorManager.reportCommand(this.params));
                break;
            case "Exit":
                writer.writeLine(this.reactorManager.exitCommand(this.params));
                break;
        }
    }
}
