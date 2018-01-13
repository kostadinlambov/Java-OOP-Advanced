package p01_Logger_Chain_of_Responsibility.loggers;

import p01_Logger_Chain_of_Responsibility.LogType;
import p01_Logger_Chain_of_Responsibility.abstractClasses.AbstractLogger;

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
