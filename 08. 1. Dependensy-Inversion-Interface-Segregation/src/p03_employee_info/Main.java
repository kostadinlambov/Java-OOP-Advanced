package p03_employee_info;

import p03_employee_info.Interfaces.Database;
import p03_employee_info.Interfaces.Formatter;
import p03_employee_info.Interfaces.InfoProvider;

public class Main {
    public static void main(String[] args) {
        Database database = new EmployeeDatabase();
        InfoProvider employeeInfo = new EmployeeInfoProvider(database);
        Formatter formatter = new ConsoleFormatter();

        String output = formatter.format(employeeInfo.getEmployeesByName());
        System.out.println(output);
    }
}
