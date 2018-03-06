package cn.java8speclial.onlyo.StreamAPI;

import cn.java8speclial.onlyo.entity.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestStreamAPI2 {

    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66),
            new Employee(101, "张三", 18, 9999.99),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 9, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55));
    // 中间操作
    /**
     * 筛选与切片
     * filter --接收Lambda，从流中排除某些元素
     * limit -- 截断流，使其元素不超过给定数量
     * skip（n）-- 跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个 则返回一个空流。与limit（n） 互补
     * distinct--筛选，通过流所产生元素的hashcode（）和equals（）去除重复元素
     */

    // 内部迭代

    // filter
    @Test
    public void test1() {
        Stream<Employee> streams = emps.stream().filter(x -> {
            return x.getAge() > 35;
        });
        streams.forEach(System.out::println);
    }

    // limit 只要找到前两个符合条件的时候就不会往下走
    @Test
    public void test2() {
        emps.stream().filter(x -> x.getSalary() > 5000).limit(2).forEach(System.out::println);
    }

    //skip 跳过
    @Test
    public void test3() {
        emps.stream().filter(x -> x.getSalary() > 5000).skip(2).distinct().forEach(System.out::println);
    }
}
