package p08_Military_Elite.implementation;

import p08_Military_Elite.interfaces.Private;

public class PrivateImpl extends SoldierImpl implements Private {
    private double salary = 0.0;

    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.setSalary(salary);
    }

    @Override
    public String toString() {
        return String.format("%s Salary: %.2f",super.toString(), this.getSalary());
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }
}
