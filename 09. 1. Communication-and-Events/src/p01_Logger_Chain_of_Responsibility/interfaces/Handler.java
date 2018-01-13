package p01_Logger_Chain_of_Responsibility.interfaces;

import p01_Logger_Chain_of_Responsibility.LogType;

public interface Handler {
    void handle(LogType logType, String message);

    void setSuccessor(Handler handler);
}
