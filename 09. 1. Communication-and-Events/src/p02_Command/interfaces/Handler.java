package p02_Command.interfaces;

import p02_Command.LogType;

public interface Handler {
    void handle(LogType logType, String message);

    void setSuccessor(Handler handler);
}
