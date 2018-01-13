package p04_Observer;

import p04_Observer.interfaces.Command;
import p04_Observer.interfaces.Executor;

public class CommandExecutor implements Executor {
    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}
