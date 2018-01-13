package p01_Logger_Chain_of_Responsibility.loggers;


import p01_Logger_Chain_of_Responsibility.LogType;
import p01_Logger_Chain_of_Responsibility.abstractClasses.AbstractLogger;

public class EventLogger extends AbstractLogger {

    @Override
    public void handle(LogType logType, String message) {
        if (logType == LogType.EVENT) {
            System.out.println(logType.name() + ": " + message);
        } else {
            if (super.getSuccessor() != null) {
                super.getSuccessor().handle(logType, message);
            }
        }
    }
}
