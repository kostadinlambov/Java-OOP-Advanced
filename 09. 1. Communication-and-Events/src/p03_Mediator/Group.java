package p03_Mediator;

import p03_Mediator.interfaces.AttackGroup;
import p03_Mediator.interfaces.Attacker;
import p03_Mediator.interfaces.Target;

import java.util.ArrayList;
import java.util.List;

public class Group implements AttackGroup {
    private List<Attacker> attackerList;

    public Group() {
        this.attackerList = new ArrayList<>();
    }

    @Override
    public void addMember(Attacker attacker) {
        this.attackerList.add(attacker);
    }

    @Override
    public void groupTarget(Target target) {
        for (Attacker attacker : attackerList) {
            attacker.setTarget(target);
        }
    }

    @Override
    public void groupAttack() {
        for (Attacker attacker : attackerList) {
            attacker.attack();
        }
    }
}
