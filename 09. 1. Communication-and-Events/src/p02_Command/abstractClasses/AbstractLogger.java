package p02_Command.abstractClasses;

import p02_Command.interfaces.Handler;

public abstract class AbstractLogger implements Handler {
    private Handler successor;

    protected Handler getSuccessor(){
        return this.successor;
    }

    @Override
    public void setSuccessor(Handler handler) {
        this.successor = handler;
    }
}
