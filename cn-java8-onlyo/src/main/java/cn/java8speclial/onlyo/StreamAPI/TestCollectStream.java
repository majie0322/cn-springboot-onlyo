package cn.java8speclial.onlyo.StreamAPI;

import cn.java8speclial.onlyo.entity.Employee;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCollectStream {

    //获取流
    @Test
    public void tests(){
        // 1 可以通过collection系列集合提供的stream（）或者paralleStream
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        // 2 通过Arrays 中静态方法stream() 获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);

        // 3 通过Stream类中 静态方法of（）
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        // 4 创建无限流
        // 迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(10).forEach(System.out::println);
    }

    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 79, 6666.66, Employee.Status.BUSY),
            new Employee(101,"张三", 18, 9999.99, Employee.Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Employee.Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77,Employee.Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Employee.Status.BUSY)
    );

    // //collect——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
    @Test
    public void test6() {
        List<String> list = emps.stream().map(Employee::getName).collect(Collectors.toList());

        list.forEach(System.out::println);

        System.out.println("----------------------------------");

        Set<String> set = emps.stream().map(Employee::getName).collect(Collectors.toSet());

        set.forEach(System.out::println);

        System.out.println("----------------------------------");

        HashSet<String> hs = emps.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));

        hs.forEach(System.out::println);
    }

    @Test
    public void test7() {

        // 最大值
        Optional<Double> max = emps.stream().map(Employee::getSalary).collect(Collectors.maxBy(Double::compare));

        System.out.println(max.get());

        // 最小值
        Optional<Employee> op = emps.stream().collect(
                Collectors.minBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));

        System.out.println(op.get());

        // 总和
        Double sum = emps.stream().collect(Collectors.summingDouble(Employee::getSalary));

        System.out.println(sum);
        // 平均值
        Double avg = emps.stream().collect(Collectors.averagingDouble(Employee::getSalary));

        System.out.println(avg);

        // 总数
        Long count = emps.stream().collect(Collectors.counting());

        System.out.println(count);

        System.out.println("--------------------------------------------");

        DoubleSummaryStatistics dss = emps.stream().collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println(dss.getMax());
    }
}
