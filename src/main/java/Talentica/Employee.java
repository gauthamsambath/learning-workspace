package Talentica;

public class Employee implements Comparable<Employee>{

    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Employee o) {
        int val =  this.name.compareTo(o.name);
        if (val == 0){
            return Integer.compare(this.age, o.age);
        }else {
            return this.name.compareTo(o.name);
        }
    }


}
