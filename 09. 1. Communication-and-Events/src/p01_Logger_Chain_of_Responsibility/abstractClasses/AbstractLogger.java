package p01_Logger_Chain_of_Responsibility.abstractClasses;

import p01_Logger_Chain_of_Responsibility.interfaces.Handler;

public abstract class AbstractLogger implements Handler{
    private Handler successor;

    protected Handler getSuccessor(){
        return this.successor;
    }

    @Override
    public void setSuccessor(Handler handler) {
        this.successor = handler;
    }
}
