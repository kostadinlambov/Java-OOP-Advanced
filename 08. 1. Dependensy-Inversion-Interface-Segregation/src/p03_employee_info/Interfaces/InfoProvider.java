package p03_employee_info.Interfaces;

import p03_employee_info.Employee;

import java.util.List;

public interface InfoProvider {

    public List<Employee> getEmployeesByName();

    public Iterable<Employee> getEmployeesBySalary();
}
