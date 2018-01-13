package p02_Kings_Gambit.commands;

import p02_Kings_Gambit.interfaces.Executable;
import p02_Kings_Gambit.interfaces.GuardsGroup;

public class KillExecutable implements Executable {

    private String warriorName;
    private GuardsGroup guardsGroup;

    public KillExecutable(String waririorName, GuardsGroup guardsGroup) {
        this.warriorName = waririorName;
        this.guardsGroup = guardsGroup;
    }

    @Override
    public void execute() {
        this.guardsGroup.remove(this.warriorName);
    }
}
