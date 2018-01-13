package p04_Observer;


import p04_Observer.abstractClasses.AbstractHero;
import p04_Observer.commands.GroupAttackCommand;
import p04_Observer.commands.GroupTargetCommand;
import p04_Observer.heroes.Warrior;
import p04_Observer.interfaces.*;
import p04_Observer.loggers.CombatLogger;
import p04_Observer.loggers.EventLogger;

public class Main {
    public static void main(String[] args) {

        Handler combatLogger = new CombatLogger();
        Handler eventLogger = new EventLogger();

        combatLogger.setSuccessor(eventLogger);

        AbstractHero attacker1 = new Warrior("Pesho", 10, combatLogger);
        AbstractHero attacker2 = new Warrior("Gosho", 12, combatLogger);
        AbstractHero attacker3 = new Warrior("Stamat", 5, combatLogger);
        AbstractHero attacker4 = new Warrior("Jivko", 3, combatLogger);
        AbstractHero attacker5 = new Warrior("Ivan", 21, combatLogger);

        Dragon target = new Dragon("Dragon", 44, 5, combatLogger);

        AttackGroup group = new Group();
        group.addMember(attacker1);
        group.addMember(attacker2);
        group.addMember(attacker3);
        group.addMember(attacker4);
        group.addMember(attacker5);

        target.register(attacker1);
        target.register(attacker2);
        target.register(attacker3);
        target.register(attacker4);
        target.register(attacker5);

        Command setTargetGroup = new GroupTargetCommand(group, target);
        Command groupAttackCommand = new GroupAttackCommand(group);

        Executor commandExecutor = new CommandExecutor();

        commandExecutor.executeCommand(setTargetGroup);
        commandExecutor.executeCommand(groupAttackCommand);
    }
}
