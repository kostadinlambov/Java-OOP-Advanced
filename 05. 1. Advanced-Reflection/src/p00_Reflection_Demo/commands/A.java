package p00_Reflection_Demo.commands;

import p00_Reflection_Demo.annotation.Command;
import p00_Reflection_Demo.interfaces.Executable;

@Command(value = "a")
public class A implements Executable {
    @Override
    public void execute() {
        System.out.println("Pesho");
    }
}
