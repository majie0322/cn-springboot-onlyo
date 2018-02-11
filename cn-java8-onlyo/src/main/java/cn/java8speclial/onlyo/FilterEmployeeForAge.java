package cn.java8speclial.onlyo;

import cn.java8speclial.onlyo.entity.Employee;
import cn.java8speclial.onlyo.entity.MyPredicate;

public class FilterEmployeeForAge implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee t) {
        return t.getAge() <= 35;
    }

}
