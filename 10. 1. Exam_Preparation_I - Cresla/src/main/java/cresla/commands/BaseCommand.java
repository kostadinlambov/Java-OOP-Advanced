package cresla.commands;

import cresla.interfaces.Manager;

import java.util.List;

public abstract class BaseCommand implements Manager{

    @Override
    public String reactorCommand(List<String> arguments) {
        return null;
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        return null;
    }

    @Override
    public String reportCommand(List<String> arguments) {
        return null;
    }

    @Override
    public String exitCommand(List<String> arguments) {
        return null;
    }
}
