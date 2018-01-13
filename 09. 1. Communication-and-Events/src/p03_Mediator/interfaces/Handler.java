package p03_Mediator.interfaces;

import p03_Mediator.enums.LogType;

public interface Handler {
    void handle(LogType logType, String message);

    void setSuccessor(Handler handler);
}
