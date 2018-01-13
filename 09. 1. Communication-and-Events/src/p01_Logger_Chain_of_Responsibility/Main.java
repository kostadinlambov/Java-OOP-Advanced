package p01_Logger_Chain_of_Responsibility;

import p01_Logger_Chain_of_Responsibility.interfaces.Attacker;
import p01_Logger_Chain_of_Responsibility.interfaces.Handler;
import p01_Logger_Chain_of_Responsibility.interfaces.Target;
import p01_Logger_Chain_of_Responsibility.loggers.CombatLogger;
import p01_Logger_Chain_of_Responsibility.loggers.EventLogger;

public class Main {
    public static void main(String[] args) {

        Handler combatLogger = new CombatLogger();
        Handler eventLogger = new EventLogger();

        combatLogger.setSuccessor(eventLogger);

        Attacker attacker = new Warrior("Pesho", 10, combatLogger);
        Target target = new Dragon("Gosho", 10, 5, combatLogger);

        attacker.setTarget(target);
        attacker.attack();
    }
}
