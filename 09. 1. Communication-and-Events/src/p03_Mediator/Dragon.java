package p03_Mediator;

import p03_Mediator.enums.LogType;
import p03_Mediator.interfaces.Handler;
import p03_Mediator.interfaces.Target;

public class Dragon implements Target {

    private static final String THIS_DIED_EVENT = "%s dies";

    private String id;
    private int hp;
    private int reward;
    private boolean eventTriggered;
    private Handler handler;

    public Dragon(String id, int hp, int reward, Handler handler) {
        this.id = id;
        this.hp = hp;
        this.reward = reward;
        this.handler = handler;
    }

    @Override
    public void receiveDamage(int dmg) {
        if (!this.isDead()) {
            this.hp -= dmg;
            this.handler.handle(LogType.EVENT, "Target health is: " + this.hp );
        }

        if (this.isDead() && !eventTriggered) {
            this.handler.handle(LogType.EVENT, String.format(THIS_DIED_EVENT, this));
            this.eventTriggered = true;
        }
    }

    @Override
    public boolean isDead() {
        return this.hp <= 0;
    }

    @Override
    public String toString() {
        return this.id;
    }
}
