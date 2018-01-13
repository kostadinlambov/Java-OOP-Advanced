package blobs.core.commands;

import blobs.annotations.Inject;
import blobs.core.BaseCommand;
import blobs.utility.MutableBoolean;

public class ReportEventsCommand extends BaseCommand {

    @Inject
    private MutableBoolean isEventToggled;

    @Override
    public String execute() {
        this.isEventToggled.setFlag(true);
        return null;
    }
}
