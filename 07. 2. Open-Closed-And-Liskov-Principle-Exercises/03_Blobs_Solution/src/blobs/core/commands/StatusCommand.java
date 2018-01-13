package blobs.core.commands;

import blobs.core.BaseCommand;
import blobs.interfaces.Blob;

public class StatusCommand extends BaseCommand {

    @Override
    public String execute() {
        StringBuilder sb = new StringBuilder();
        for (Blob blob : super.getBlobRepository().findAll().values()) {
            sb.append(blob).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
