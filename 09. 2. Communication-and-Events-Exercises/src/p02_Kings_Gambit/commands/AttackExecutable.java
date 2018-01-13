package p02_Kings_Gambit.commands;

import p02_Kings_Gambit.interfaces.Executable;
import p02_Kings_Gambit.interfaces.GuardsGroup;

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
