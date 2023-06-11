package SPGlobalProblem;

import java.util.ArrayList;
import java.util.List;

public final class Company  {

    private final int comapnyId;
    private final String companyName;
    private final List<Employee> listOfEmployees;

    public Company(int comapnyId, String companyName, List<Employee> listOfEmployees) {
        this.comapnyId = comapnyId;
        this.companyName = companyName;
        this.listOfEmployees = createDeepCopyOfEmployeeList(listOfEmployees);
    }

    private List<Employee> createDeepCopyOfEmployeeList(List<Employee> listOfEmployees) {
        List<Employee> deepCopyList = new ArrayList<>();
        for (Employee employee: listOfEmployees) {
            Employee employeeCopy = employee.clone();
            deepCopyList.add(employeeCopy);
        }
        return deepCopyList;
    }


    public static void main(String[] args) {
        Employee employee1 = new Employee(1, 23, 10000, "gautham");

        List<Employee> employeese = new ArrayList<>();
        employeese.add(employee1);

        Company company = new Company(1, "xyz", employeese);
        employee1.setEmployeeId(2);
        employee1.setName("name2");
        Employee employee2 = new Employee(2, 25, 12000, "sambath");
        employeese.add(employee2);

        System.out.println(company);

    }



    public int getComapnyId() {
        return comapnyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public List<Employee> getListOfEmployees() {
        return new ArrayList<>(listOfEmployees);
    }

    @Override
    public String toString() {
        return "Company{" +
                "comapnyId=" + comapnyId +
                ", companyName='" + companyName + '\'' +
                ", listOfEmployees=" + listOfEmployees +
                '}';
    }


}
