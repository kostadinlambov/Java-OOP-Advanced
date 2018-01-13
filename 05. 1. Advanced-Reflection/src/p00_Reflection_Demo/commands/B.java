package p00_Reflection_Demo.commands;

import p00_Reflection_Demo.annotation.Command;
import p00_Reflection_Demo.interfaces.Executable;

@Command(value = "b")
public class B implements Executable{

    @Override
    public void execute(){
        System.out.println("Gosho");
    }
}
