package p06_Mirror_Image;

import p06_Mirror_Image.interfaces.Command;
import p06_Mirror_Image.interfaces.Executor;

public class CommandExecutor implements Executor {
    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}
