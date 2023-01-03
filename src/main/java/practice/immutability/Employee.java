package practice.immutability;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Employee {
    private final int empId;
    private final String empName;
    private final double salary;
    private final List<String> departments;

    public Employee(int empId, String empName, double salary,List<String> departments) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.departments = Collections.unmodifiableList(departments);
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public Double getSalary() {
        return salary;
    }

    public List<String> getDepartments() {
        return departments;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", salary=" + salary +
                ", departments=" + departments +
                '}';
    }

    public static void main(String[] args) {
        //using Arraylist
        List<String> depts = new ArrayList<>();
        depts.add("HR");
        depts.add("Payroll");
        Employee employee = new Employee(1,"Belinda",100000.00, depts);
        System.out.println(employee);
        employee.getDepartments().add("Finance");
        System.out.println(employee);

        //using Arrays.asList() or List.of() => both return UnSupportedOperationException when the size of the list is changed.
        //You don't need to use the Collections.unmodifiableList(list) above in the constructor.
        Employee employee1 = new Employee(2,"Keith",200000.00, Arrays.asList("HR","Payroll"));
        System.out.println(employee1);
    }
}
