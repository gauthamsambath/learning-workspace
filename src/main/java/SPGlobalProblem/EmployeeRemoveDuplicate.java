package SPGlobalProblem;

import java.util.*;

public class EmployeeRemoveDuplicate {

    public static class Employee implements Comparable<Employee>{
        int id;
        String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int compareTo(Employee o) {
           return this.name.compareTo(o.name)<0?1:-1;
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Employee>> mapOfEmployees = new HashMap<>();
        List<Employee> listOfEmployees = new ArrayList<>();
        Employee employee1 = new Employee(1,"Gautham");
        Employee employee2 = new Employee(1,"Gautham");
        Employee employee3 = new Employee(2,"Raj");



        listOfEmployees.add(employee1);
        listOfEmployees.add(employee2);
        listOfEmployees.add(employee3);


        Collections.sort(listOfEmployees);


//
//        for (Employee employee: listOfEmployees) {
//            if (!mapOfEmployees.containsKey(employee.id)){
//                mapOfEmployees.put(employee.id,new ArrayList<>());
//                mapOfEmployees.get(employee.id).add(employee);
//            } else {
//                mapOfEmployees.get(employee.id).add(employee);
//            }
//        }
//
//
//        List<Employee> employeesWithoutDuplicate = new ArrayList<>();
//
//        for (Map.Entry<Integer,List<Employee>> element: mapOfEmployees.entrySet()) {
//                employeesWithoutDuplicate.add(element.getValue().get(0));
//        }
//
        listOfEmployees.forEach(x->{
            System.out.println("Employee id = "+x.id);
            System.out.println("Employee id = "+x.name);
        });

    }
}
