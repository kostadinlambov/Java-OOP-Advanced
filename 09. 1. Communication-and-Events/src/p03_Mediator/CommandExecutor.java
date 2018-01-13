package p03_Mediator;

import p03_Mediator.interfaces.Command;
import p03_Mediator.interfaces.Executor;

public class CommandExecutor implements Executor {
    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}
