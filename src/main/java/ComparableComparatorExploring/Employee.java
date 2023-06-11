package ComparableComparatorExploring;

import java.util.Arrays;
import java.util.Comparator;

public class Employee implements Comparable<Employee>{
    int id;
    String  name;
    boolean inBench;
    String DepartmentName;

    public Employee(int id, String name, boolean inBench, String departmentName) {
        this.id = id;
        this.name = name;
        this.inBench = inBench;
        DepartmentName = departmentName;
    }

    Comparator<Employee> comparator1 = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.name.compareTo(o2.name);
        }
    };

    Comparator<Employee> comparator2 = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return String.valueOf(o1.inBench).compareTo(String.valueOf(o2.inBench));
        }
    };
    @Override
    public int compareTo(Employee o) {
        return this.id < o.id ? 1:0;
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee(1,"gautham",false,"DWP");
        Employee employee2 = new Employee(2,"manu",false,"IAP");
        Employee employee3 = new Employee(4,"sarath",false,"AX");
        Employee employee4 = new Employee(3,"dhruv",true,"ISIT");
        Employee[] employees = new Employee[4];
        employees[0] = employee1;
        employees[1] = employee2;
        employees[2] = employee3;
        employees[3] = employee4;
        Arrays.stream(employees).forEach(x-> System.out.println(x.id));
    }
}
