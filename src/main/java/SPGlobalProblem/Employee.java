package SPGlobalProblem;


//Given a list of company u have to return a map where key is company and value is list of employee ids of that company


public class Employee implements Cloneable {
    int employeeId;
    int age;
    float salary;
    String name;

    public Employee(int employeeId, int age, float salary, String name) {
        this.employeeId = employeeId;
        this.age = age;
        this.salary = salary;
        this.name = name;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public Employee clone(){
        return new Employee(employeeId, age, salary, name);

    }
    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", age=" + age +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }
}
