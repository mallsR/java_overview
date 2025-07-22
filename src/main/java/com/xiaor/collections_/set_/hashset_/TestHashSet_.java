package com.xiaor.collections_.set_.hashset_;

import java.util.HashSet;
import java.util.Objects;

public class TestHashSet_ {
    public static void main(String[] args) {
        HashSet employees = new HashSet();
        employees.add(new Employee("xiaoR", 18000, new MyDate(1997, 9, 13)));
        employees.add(new Employee("qianqian", 5000, new MyDate(2000, 4, 3)));
        employees.add(new Employee("xiaoR", 22000, new MyDate(1997, 8, 12)));

        for (Object employee : employees) {
            System.out.println(employee);
        }
    }
}


class MyDate{
    private int year;
    private int month;
    private int day;

    MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    @Override
    public String toString() {
        return "MyDate{year=" + year + ", month=" + month + ", day=" + day + "}";
    }
}

class Employee{
    private String name;
    private double salary;
    private MyDate birthday;

    Employee(String name, int salary, MyDate birthday){
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }

    // 当name和birthday相同时,认为是同一个员工,不能添加到HashSet集合中
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;  // getClass获取运行时类型
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(birthday, employee.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    @Override
    public String toString() {
        return "Employee{name=" + name + ", salary=" + salary + ", birthday=" + birthday + "}";
    }
}
