package p03_Mediator.interfaces;

public interface AttackGroup {

    void addMember(Attacker attacker);
    void groupTarget(Target target);
    void groupAttack();
}
