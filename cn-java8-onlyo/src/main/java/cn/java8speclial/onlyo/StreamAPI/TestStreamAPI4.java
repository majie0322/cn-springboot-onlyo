package cn.java8speclial.onlyo.StreamAPI;

import cn.java8speclial.onlyo.entity.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestStreamAPI4 {
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 79, 6666.66, Employee.Status.BUSY),
            new Employee(101, "张三", 18, 9999.99, Employee.Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Employee.Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Employee.Status.BUSY));
    
    // 分组
    @Test
    public void test1() {
        Map<Employee.Status, List<Employee>> map = emps.stream().collect(Collectors.groupingBy(Employee::getStatus));

        System.out.println(map);
    }

    // 多级分组
    @Test
    public void test6() {
        Map<Employee.Status, Map<String, List<Employee>>> map = emps.stream().collect(
                Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    if (e.getAge() >= 60)
                        return "老年";
                    else if (e.getAge() >= 35)
                        return "中年";
                    else
                        return "成年";
                })));

        System.out.println(map);
    }

    // 分区
    @Test
    public void test7() {
        Map<Boolean, List<Employee>> map = emps.stream().collect(
                Collectors.partitioningBy((e) -> e.getSalary() >= 5000));

        System.out.println(map);
    }

    // max min avg count
    @Test
    public void test3() {
        DoubleSummaryStatistics dss = emps.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getMax());
    }

    // 拼接 字符串
    @Test
    public void test8() {
        String str = emps.stream().map(Employee::getName).collect(Collectors.joining(",", "----", "----"));

        System.out.println(str);
    }
}
