package app.core.commands;

import app.core.BaseCommand;
import app.factories.AttackFactory;
import app.factories.BehaviorFactory;
import app.factories.BlobFactory;
import app.interfaces.Attack;
import app.interfaces.Behavior;
import app.interfaces.Blob;

import java.lang.reflect.InvocationTargetException;

public class CreateCommand extends BaseCommand{




    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Behavior behavior = BehaviorFactory.create(super.getParams().get(3));
        Attack attack = AttackFactory.create(super.getParams().get(4));
        Blob blob = BlobFactory.create(super.getParams().get(1), Integer.parseInt(super.getParams().get(2)), Integer.parseInt(super.getParams().get(2)), behavior, attack );
        super.getRepository().add(blob);
        return null;
    }
}
