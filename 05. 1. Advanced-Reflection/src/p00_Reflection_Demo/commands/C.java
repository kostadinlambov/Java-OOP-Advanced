package p00_Reflection_Demo.commands;

import p00_Reflection_Demo.annotation.Command;
import p00_Reflection_Demo.interfaces.Executable;

@Command(value = "exit")
public class C implements Executable {
    @Override
    public void execute() {
        System.exit(0);
    }
}
