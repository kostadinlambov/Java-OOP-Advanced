package p04_Work_Force.interfaces;

public interface Job  {
    String getName();

    int getHoursPerWeekRequired();

    Employee getEmployee();

    void update();
}
