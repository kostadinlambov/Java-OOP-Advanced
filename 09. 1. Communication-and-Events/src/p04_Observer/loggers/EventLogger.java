package p04_Observer.loggers;


import p04_Observer.abstractClasses.AbstractLogger;
import p04_Observer.enums.LogType;

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
