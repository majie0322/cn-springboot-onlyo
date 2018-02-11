package cn.java8speclial.onlyo;

import cn.java8speclial.onlyo.entity.Employee;
import cn.java8speclial.onlyo.entity.MyPredicate;

public class FilterEmployeeForSalary implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee t) {
        return t.getSalary() >= 5000;
    }

}
