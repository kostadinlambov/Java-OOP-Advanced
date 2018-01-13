package p02_Command;

import p02_Command.interfaces.Command;
import p02_Command.interfaces.Executor;

public class CommandExecutor implements Executor {
    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}
