package p03_Mediator.heroes;

import p03_Mediator.enums.LogType;
import p03_Mediator.abstractClasses.AbstractHero;
import p03_Mediator.interfaces.Handler;
import p03_Mediator.interfaces.Target;

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
