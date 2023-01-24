package Homework2023_01_23;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> list = List.of(
                new Employee("A", "head", "Boris", 5000),
                new Employee("A", "workerA", "Vlad", 3500),
                new Employee("A", "workerA", "Anne", 3500),
                new Employee("A", "workerB", "Denis", 2000),
                new Employee("A", "workerC", "George", 1800),
                new Employee("B", "head", "Fred", 5300),
                new Employee("B", "workerA", "George", 4000),
                new Employee("B", "workerB", "Markus", 3000),
                new Employee("B", "workerC", "Viktoria", 2400),
                new Employee("C", "head", "Anton", 4100),
                new Employee("C", "workerA", "Lisa", 2800),
                new Employee("C", "workerB", "Kate", 2300),
                new Employee("C", "workerC", "Maks", 2050),
                new Employee("C", "workerC", "George", 1900)
        );

        task7(list);
    }

    public static void task2(List<Employee> list) {
        //Сгрупировать сотрудников по должности

        System.out.println(list.stream()
                .collect(Collectors.groupingBy(Employee::getPosition))
        );
    }

    public static void task3(List<Employee> list) {
        //Вычислить среднюю зарплату всех сотрудников

        double res = list.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .getAsDouble();


        System.out.println((int)res);
    }

    public static void task4(List<Employee> list) {
        //Получить список сотрудников с зп > 1000(3000)

        List<Employee> employeeList = list.stream()
                .filter(e -> e.getSalary() > 3000)
                .collect(Collectors.toList());

        System.out.println(employeeList);
    }

    public static void task5(List<Employee> list) {
        //Получить список сотрудников из отдела маркетинг("B") и увеличить зп на 15%

        List<Employee> employeeList = list.stream()
                .filter(e -> e.getDepartment().equals("B"))
                .peek(e -> e.setSalary(e.getSalary() * 1.15))
                .collect(Collectors.toList());

        System.out.println(employeeList);
    }

    public static void task6(List<Employee> list) {
        //Получить сотрудника с самой низкой зп

        Employee employee = list.stream()
                .min(Employee::compareTo)
                .get();

        System.out.println(employee);
    }

    public static void task7(List<Employee> list) {
        //Получите сотрудников из всех отделов с максимальной зп

        /*List<Employee> employeeList = list.stream()
                .filter(e -> {
                    return e.getSalary() > 4000 && (e.getDepartment().equals("A") ||
                            e.getDepartment().equals("B") ||
                            e.getDepartment().equals("C"));
                }).collect(Collectors.toList());*/

        Map<String, Optional<Employee>> employeeList = list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Employee::compareTo)));

        System.out.println(employeeList);
    }
 }

class Employee implements Comparable<Employee> {
    private String department;
    private String position;
    private String name;
    private double salary;

    public Employee(String department, String position, String name, double salary) {
        this.department = department;
        this.position = position;
        this.name = name;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("Name: %s; position: %s; salary: %s; department: %s"
        , name, position, salary, department);
    }

    @Override
    public int compareTo(Employee o) {
        return (int)(this.getSalary() - o.getSalary());
    }
}
