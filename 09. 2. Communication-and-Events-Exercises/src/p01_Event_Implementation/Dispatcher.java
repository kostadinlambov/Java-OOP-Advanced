package p01_Event_Implementation;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    private String name;
    private List<NameChangeListener> nameChangeListenerList;

    public Dispatcher() {
        this.nameChangeListenerList = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    void addNameChangeListener(NameChangeListener nameChangeListener) {
        this.nameChangeListenerList.add(nameChangeListener);
    }

    void removeNameChangeListener(NameChangeListener nameChangeListener) {
        this.nameChangeListenerList.remove(nameChangeListener);
    }

    void fireNameChangeEvent() {
        for (NameChangeListener nameChangeListener : nameChangeListenerList) {
            NameChange event = new NameChange(this.name);
            nameChangeListener.handleChangedName(event);
        }
    }
}
