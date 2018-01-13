package p03_Mediator.loggers;

import p03_Mediator.enums.LogType;
import p03_Mediator.abstractClasses.AbstractLogger;

public class CombatLogger extends AbstractLogger {
    @Override
    public void handle(LogType logType, String message) {
        if (logType == LogType.ATTACK || logType == LogType.MAGIC) {
            System.out.println(logType.name() + ": " + message);
        } else {
            if (super.getSuccessor() != null) {
                super.getSuccessor().handle(logType, message);
            }
        }
    }
}
