package p03_employee_info.Interfaces;

import p03_employee_info.Employee;

import java.util.List;

public interface Database {
    List<Employee> readEmployees();
}
