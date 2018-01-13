package p04_Work_Force.factories;

import p04_Work_Force.interfaces.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class EmployeeFactory {
    private static final String EMPLOYEES_PACKAGE_NAME = "p04_Work_Force.employees.";

    private EmployeeFactory(){}

    public static Employee createEmployee(String name, String unitType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> employeeClass = Class.forName(EMPLOYEES_PACKAGE_NAME + unitType);
        Constructor<?> employeeConstructor = employeeClass.getDeclaredConstructor(String.class);
        Employee employee = (Employee) employeeConstructor.newInstance(name);
        return employee;
    }
}
