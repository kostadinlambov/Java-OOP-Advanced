package p05_Kings_Gambit_Extended.interfaces;

import java.util.List;

public interface GuardsGroup {
    List<Warrior> getGuards();

    void addMember(Warrior guard);

    void remove(String name);

    void groupAttack();
}
