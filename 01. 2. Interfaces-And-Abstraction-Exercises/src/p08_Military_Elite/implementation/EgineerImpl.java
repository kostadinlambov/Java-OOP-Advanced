package p08_Military_Elite.implementation;

import p08_Military_Elite.interfaces.Engineer;
import p08_Military_Elite.interfaces.Repair;

import java.util.ArrayList;
import java.util.Collection;

public class EgineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private Collection<Repair> repairs;

    public EgineerImpl(int id, String firstName, String lastName, double salary, String corps, Collection<Repair> repairs) {
        super(id, firstName, lastName, salary, corps);
        this.setRepairs(repairs);
    }

    private void setRepairs(Collection<Repair> repairs) {
        if (repairs != null) {
            this.repairs = new ArrayList<>(repairs);
        } else {
            this.repairs = new ArrayList<>();
        }
    }


    @Override
    public Collection<Repair> getRepairs() {
        return repairs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString()).append(System.lineSeparator());

        sb.append("Repairs:").append(System.lineSeparator());
        this.getRepairs().forEach(repair -> sb.append(" ").append(repair).append(System.lineSeparator()));

        return sb.toString();
    }
}
