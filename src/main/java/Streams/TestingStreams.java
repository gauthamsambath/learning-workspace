package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class TestingStreams {

    public static void main(String[] args) {

//        List<Employee> listOfEmployees = getListOfEmployees(5);
        List<Employee> listOfEmployees = new ArrayList<>();

//        create a map where key is company id and the value is list of employees with that company id

//        Map<Integer, List<Employee>> mapOfEmployeesInAGivenCompanyId = listOfEmployees.stream()
//                .collect(Collectors.groupingBy(Employee::getCompanyId));
//
//        System.out.println(mapOfEmployeesInAGivenCompanyId);

        Employee employee = new Employee(1,"Gautham",25,1000,23);
        Optional<Employee> employee2 = Optional.of(new Employee(employee));
        listOfEmployees.add(employee);
        Employee employee1 = new Employee(employee);
        employee1.setAge(23);
        listOfEmployees.add(employee1);
        System.out.println(listOfEmployees);
        System.out.println(listOfEmployees.get(0) == listOfEmployees.get(1));

    }

    private static List<Employee> getListOfEmployees(int targetNumberOfEmployees) {
        List<Employee> employeeList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < targetNumberOfEmployees; i++) {
            employeeList.add(new Employee(i, "name" + i, 25 + random.nextInt(6) + 5,
                    10000 + random.nextFloat() * 3000 + 1000, random.nextInt(targetNumberOfEmployees) + 1));
        }
        return employeeList;
    }
}
