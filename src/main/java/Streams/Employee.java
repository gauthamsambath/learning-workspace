package Streams;

public class Employee {

    private int id;
    private String name;
    private int age;
    private float salary;
    private int companyId;

    public Employee(int id, String name, int age, float salary, int companyId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.companyId = companyId;
    }

    public Employee(Employee employee) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", companyId=" + companyId +
                '}';
    }
}
