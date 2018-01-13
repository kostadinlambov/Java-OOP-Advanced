package p04_Observer.interfaces;

import p04_Observer.enums.LogType;

public interface Handler {
    void handle(LogType logType, String message);

    void setSuccessor(Handler handler);
}
