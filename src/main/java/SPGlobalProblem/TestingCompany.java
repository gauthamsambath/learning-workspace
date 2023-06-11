package SPGlobalProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestingCompany {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee(1,"gautham"));


        Predicate<Integer> predicate1 = (x)->{
            return x>25;
        };

//        List<Employee> employeesAbove25 = returnListOfEmployeesBasedOnCondition(predicate1,employees);
//        System.out.println(employeesAbove25);



    }

    public static List<Employee> returnListOfEmployeesBasedOnCondition(Predicate<Object> predicate, List<Employee> employees) {
        return employees.stream().filter(predicate).collect(Collectors.toList());
    }
}
