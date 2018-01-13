package p08_Military_Elite.implementation;

import p08_Military_Elite.interfaces.Repair;

public class RepairImpl implements Repair {
    private String partName;
    private int hours;

    public RepairImpl(String partName, int hours) {
        this.setHours(hours);
        this.setPartName(partName);
    }

    @Override
    public String getPartName() {
        return this.partName;
    }

    @Override
    public int getHours() {
        return this.hours;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d", this.getPartName(), this.getHours());
    }


    private void setHours(int hours) {
        this.hours = hours;
    }

    private void setPartName(String partName) {
        this.partName = partName;
    }
}
