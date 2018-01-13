package p03_Mediator;

import p03_Mediator.commands.AttackCommand;
import p03_Mediator.commands.GroupAttackCommand;
import p03_Mediator.commands.GroupTargetCommand;
import p03_Mediator.commands.TargetCommand;
import p03_Mediator.heroes.Warrior;
import p03_Mediator.interfaces.*;
import p03_Mediator.loggers.CombatLogger;
import p03_Mediator.loggers.EventLogger;

public class Main {
    public static void main(String[] args) {

        Handler combatLogger = new CombatLogger();
        Handler eventLogger = new EventLogger();

        combatLogger.setSuccessor(eventLogger);

        Attacker attacker1 = new Warrior("Pesho", 10, combatLogger);
        Attacker attacker2 = new Warrior("Gosho", 12, combatLogger);
        Attacker attacker3 = new Warrior("Stamat", 5, combatLogger);
        Attacker attacker4= new Warrior("Jivko", 3, combatLogger);
        Attacker attacker5 = new Warrior("Ivan", 21, combatLogger);

        Target target = new Dragon("Dragon", 44, 5, combatLogger);

        AttackGroup group = new Group();
        group.addMember(attacker1);
        group.addMember(attacker2);
        group.addMember(attacker3);
        group.addMember(attacker4);
        group.addMember(attacker5);

        Command setTargetGroup = new GroupTargetCommand(group, target);
        Command groupAttackCommand = new GroupAttackCommand(group);

        Executor commandExecutor = new CommandExecutor();

        commandExecutor.executeCommand(setTargetGroup);
        commandExecutor.executeCommand(groupAttackCommand);
    }
}
