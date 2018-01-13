package p02_Command;

import p02_Command.commands.AttackCommand;
import p02_Command.commands.TargetCommand;
import p02_Command.interfaces.*;
import p02_Command.loggers.CombatLogger;
import p02_Command.loggers.EventLogger;

public class Main {
    public static void main(String[] args) {

        Handler combatLogger = new CombatLogger();
        Handler eventLogger = new EventLogger();

        combatLogger.setSuccessor(eventLogger);

        Attacker attacker = new Warrior("Pesho", 10, combatLogger);
        Target target = new Dragon("Gosho", 10, 5, combatLogger);

        Executor commandExecutor = new CommandExecutor();

        Command setTarget = new TargetCommand(attacker, target);
        Command attackCommand = new AttackCommand(attacker);

        commandExecutor.executeCommand(setTarget);
        commandExecutor.executeCommand(attackCommand);


    }
}
