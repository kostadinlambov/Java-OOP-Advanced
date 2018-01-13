package p05_Kings_Gambit_Extended.commands;

import p05_Kings_Gambit_Extended.interfaces.Executable;
import p05_Kings_Gambit_Extended.interfaces.GuardsGroup;

public class AttackExecutable implements Executable {

    private GuardsGroup guardsGroup;

    public AttackExecutable(GuardsGroup guardsGroup) {
        this.guardsGroup = guardsGroup;
    }

    @Override
    public void execute() {
        guardsGroup.groupAttack();
    }
}
