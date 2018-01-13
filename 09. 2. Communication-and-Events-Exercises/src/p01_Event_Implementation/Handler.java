package p01_Event_Implementation;

public class Handler implements NameChangeListener {

    @Override
    public void handleChangedName(NameChange event) {
        System.out.printf("Dispatcher's name changed to %s.%n", event.getChangedName());
    }
}
