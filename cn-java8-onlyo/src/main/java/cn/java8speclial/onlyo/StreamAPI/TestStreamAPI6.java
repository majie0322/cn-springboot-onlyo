package cn.java8speclial.onlyo.StreamAPI;

import cn.java8speclial.onlyo.entity.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TestStreamAPI6 {

    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66),
            new Employee(101, "张三", 18, 9999.99),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 9, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55));

    // sorted() -- 自然排序
    // sorted（Comparator com）-- 定制排（Comparator）

    @Test
    public void test1(){

        List<String> lis = Arrays.asList("bbbb", "aaa", "ccc","dddd");
        lis.stream().sorted().forEach(System.out::println);

        System.out.println("-----------");

        emps.stream().sorted((e1,e2)->{
            if (e1.getAge().equals(e2.getAge())) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return e1.getAge().compareTo(e2.getAge());
            }
        }).forEach(System.out::println);
    }
}
