package p01_Logger_Chain_of_Responsibility;

import p01_Logger_Chain_of_Responsibility.abstractClasses.AbstractHero;
import p01_Logger_Chain_of_Responsibility.interfaces.Handler;
import p01_Logger_Chain_of_Responsibility.interfaces.Target;

public class Warrior extends AbstractHero {

    private static final String ATTACK_MESSAGE = "%s damages %s for %s";

    public Warrior(String id, int dmg, Handler handler) {
        super(id, dmg, handler);
    }

    @Override
    protected void executeClassSpecificAttack(Target target, int dmg) {
       super.getHandler().handle(LogType.ATTACK,  String.format(ATTACK_MESSAGE, this, target, dmg));
        target.receiveDamage(dmg);
    }
}
