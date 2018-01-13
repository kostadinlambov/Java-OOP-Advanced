package P04_DetailPrinter;

import java.util.ArrayList;

public class DetailsPrinter {

    private Iterable<Employee> employees;

    public DetailsPrinter(Iterable<Employee> employees) {
        this.employees = employees;
    }

    public void printDetails() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Pesho"));
        employees.add(new Manager("Gosho", new ArrayList<>()));
        DetailsPrinter printer = new DetailsPrinter(employees);
        printer.printDetails();
    }
}
