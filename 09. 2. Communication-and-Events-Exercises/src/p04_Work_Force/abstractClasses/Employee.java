package p04_Work_Force.abstractClasses;

public abstract class Employee implements p04_Work_Force.interfaces.Employee {
    private String name;
    private int workHoursPerWeek;

    public Employee(String name, int workHoursPerWeek) {
        this.name = name;
        this.workHoursPerWeek = workHoursPerWeek;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getWorkHoursPerWeek() {
        return this.workHoursPerWeek;
    }
}
