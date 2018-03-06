package cn.java8speclial.onlyo;

import cn.java8speclial.onlyo.entity.Employee;
import cn.java8speclial.onlyo.entity.Student;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        Employee e = new Employee();
        e.setAge(11);
        Integer a = Optional.ofNullable(e.getAge()).orElse(0);
        System.out.println(a);

        Student s = new Student();
        s.setId("1");
    }
}
