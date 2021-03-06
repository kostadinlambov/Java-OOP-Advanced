package p04_Work_Force.employees;

import p04_Work_Force.abstractClasses.Employee;

public class PartTimeEmployee extends Employee {
    private static final int WORK_HOURS_PER_WEEK_PART_TIME_EMPLOYEE = 20;

    public PartTimeEmployee(String name) {
        super(name, WORK_HOURS_PER_WEEK_PART_TIME_EMPLOYEE);
    }
}
