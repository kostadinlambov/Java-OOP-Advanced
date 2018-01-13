package p08_Military_Elite.implementation;

import p08_Military_Elite.interfaces.LeutenantGeneral;
import p08_Military_Elite.interfaces.Private;

import java.util.ArrayList;
import java.util.Collection;


public class LeutenantGeneralImpl extends PrivateImpl implements LeutenantGeneral {
    private Collection<Private> privates;

    public LeutenantGeneralImpl(int id, String firstName, String lastName, double salary, Collection<Private> privates) {
        super(id, firstName, lastName, salary);
        this.setPrivates(privates);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString()).append(System.lineSeparator());
        sb.append("Privates:").append(System.lineSeparator());
        //.sorted((f1, f2) -> Long.compare(f2.lastModified(), f1.lastModified())


        this.getPrivates().stream().sorted((p1,p2) -> Long.compare(p2.getId(), p1.getId())).forEach(p -> sb.append("  ").append(p).append(System.lineSeparator()));
        //this.getPrivates().forEach(p -> sb.append("  ").append(p).append(System.lineSeparator()));
        return sb.toString();
    }

    @Override
    public Collection<Private> getPrivates() {
        return this.privates;
    }


    private void setPrivates(Collection<Private> privates) {
        if (privates != null) {
            this.privates = new ArrayList<>(privates);
        } else {
            this.privates = new ArrayList<>();
        }
    }
}
