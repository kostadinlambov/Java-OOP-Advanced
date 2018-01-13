package p02_Command.loggers;


import p02_Command.LogType;
import p02_Command.abstractClasses.AbstractLogger;

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
