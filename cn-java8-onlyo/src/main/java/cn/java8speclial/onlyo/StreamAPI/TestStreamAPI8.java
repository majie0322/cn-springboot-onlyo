package cn.java8speclial.onlyo.StreamAPI;

import cn.java8speclial.onlyo.entity.Employee;
import net.sf.ehcache.search.aggregator.Sum;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TestStreamAPI8 {

    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 79, 6666.66, Employee.Status.BUSY),
            new Employee(101, "张三", 18, 9999.99, Employee.Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Employee.Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Employee.Status.BUSY));

    //归约 可以将流中元素反复结合起来 得到一个值
    /**
     * reduce(T identity, BinaryOperator)  reduce(BinaryOperator)
     */
    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        Integer i = list.stream().reduce(0,(x,y)->x+y);

        Double d = emps.stream().map(Employee::getSalary).reduce(Double::sum).get();
        System.out.println(d);
    }

    /**
     * 收集
     * Collection 将流转换成其他形式。接收Collection接口的实现，用于给Stream 中元素做汇总的方法
     */
    @Test
    public void test2(){
        emps.stream().map(Employee::getName).collect(Collectors.toList()).forEach(System.out::println);

        HashSet<String> hashSet = emps.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));

        //工资的平均值averagingDouble
        //求和 summingDouble
        //最大 maxBy
        //最小 minBy
        Double avg = emps.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(avg);
    }

    //分组
    @Test
    public void test3() {
        Map<Employee.Status, List<Employee>> map = emps.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
    }
    //多级分组

    @Test
    public void test4(){
        Map<Employee.Status, Map<String, List<Employee>>> map = emps.stream().collect(
                Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    if (((Employee) e).getAge() > 40) {
                        return "1111";
                    } else {
                        return "2222";
                    }
                })));
        System.out.println(map);
    }


    //分区
    @Test
    public void test5() {
        Map<Boolean, List<Employee>> map = emps.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 8000));
        System.out.println(map);
    }

    //直接拿平均数 最大值 最小值 cout
    @Test
    public void test6(){
        DoubleSummaryStatistics d =  emps.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
    }

    @Test
    public void test7(){
        String str = emps.stream().map(Employee::getName).collect(Collectors.joining("/n"));
        System.out.println(str);
    }
}
