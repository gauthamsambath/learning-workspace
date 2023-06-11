package Streams;

import java.util.List;

public class Company {
    private int companyId;
    private String companyName;
    private List<Employee> employeeList;
    private float companyTurnOver;

    public Company(int companyId, String companyName, List<Employee> employeeList, float companyTurnOver) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.employeeList = employeeList;
        this.companyTurnOver = companyTurnOver;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public float getCompanyTurnOver() {
        return companyTurnOver;
    }

    public void setCompanyTurnOver(float companyTurnOver) {
        this.companyTurnOver = companyTurnOver;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", employeeList=" + employeeList +
                ", companyTurnOver=" + companyTurnOver +
                '}';
    }
}
