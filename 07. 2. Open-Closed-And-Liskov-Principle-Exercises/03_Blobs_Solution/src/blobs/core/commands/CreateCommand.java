package blobs.core.commands;

import blobs.annotations.Inject;
import blobs.core.BaseCommand;
import blobs.factories.AttackFactory;
import blobs.factories.BehaviorFactory;
import blobs.factories.BlobFactory;
import blobs.factories.ObserverFactory;
import blobs.interfaces.Attack;
import blobs.interfaces.Behavior;
import blobs.interfaces.Blob;
import blobs.interfaces.OutputWriter;
import blobs.utility.MutableBoolean;

public class CreateCommand extends BaseCommand {

    @Inject
    private MutableBoolean isEventToggled;
    @Inject
    private OutputWriter writer;

    @Override
    public String execute() {
        Behavior behavior = BehaviorFactory.create(super.getParams().get(3));
        Attack attack = AttackFactory.create(super.getParams().get(4));

        Blob blob = BlobFactory.create(super.getParams().get(0), Integer.parseInt(super.getParams().get(1)), Integer.parseInt(super.getParams().get(2)), behavior, attack);

        super.getBlobRepository().add(blob);

        if (this.isEventToggled.isFlag()) {
            blob.attach(ObserverFactory.createTogglesBehaviorObserver(blob, this.writer));
            blob.attach(ObserverFactory.createDeadBlobObserver(blob, this.writer));
        }

        return null;
    }
}
