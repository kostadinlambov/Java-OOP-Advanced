package blobs.core.commands;

import blobs.core.BaseCommand;
import blobs.interfaces.Blob;

public class AttackCommand extends BaseCommand {

    @Override
    public String execute() {
        if (super.getBlobRepository().findByName(super.getParams().get(0)) != null && super.getBlobRepository().findByName(super.getParams().get(1)) != null) {
            Blob attacker = super.getBlobRepository().findByName(super.getParams().get(0));
            Blob target = super.getBlobRepository().findByName(super.getParams().get(1));

            attacker.attack(target);
        }

        return null;
    }
}
