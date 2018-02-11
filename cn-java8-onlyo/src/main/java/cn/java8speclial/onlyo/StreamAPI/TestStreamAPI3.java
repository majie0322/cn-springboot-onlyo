package cn.java8speclial.onlyo.StreamAPI;

import cn.java8speclial.onlyo.entity.Employee;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestStreamAPI3 {

    List<Employee> emps = Arrays.asList(new Employee(102, "李四", 79, 6666.66, Employee.Status.BUSY), new Employee(101,
            "张三", 18, 9999.99, Employee.Status.FREE), new Employee(103, "王五", 28, 3333.33, Employee.Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.BUSY), new Employee(104, "赵六", 8, 7777.77,
                    Employee.Status.FREE), new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE), new Employee(105,
                    "田七", 38, 5555.55, Employee.Status.BUSY));

    // 3. 终止操作
    /*
     * allMatch——检查是否匹配所有元素
     * anyMatch——检查是否至少匹配一个元素
     * noneMatch——检查是否没有匹配的元素
     * findFirst——返回第一个元素
     * findAny——返回当前流中的任意元素
     * count——返回流中元素的总个数
     * max——返回流中最大值
     * min——返回流中最小值
     */
    @Test
    public void test1() {
        boolean bl = emps.stream().allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));

        System.out.println(bl);

        boolean bl1 = emps.stream().anyMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));

        System.out.println(bl1);

        boolean bl2 = emps.stream().noneMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));

        System.out.println(bl2);
    }

    @Test
    public void test2() {
        Optional<Employee> op = emps.stream().sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();
        System.out.println(op.get());

        Optional<Employee> op2 = emps.parallelStream().filter((e) -> e.getStatus().equals(Employee.Status.FREE))
                .findAny();

        System.out.println(op2.get());
    }

    @Test
    public void test3() {
        long count = emps.stream().filter((e) -> e.getStatus().equals(Employee.Status.FREE)).count();

        System.out.println(count);
        Optional<Double> op = emps.stream().map(Employee::getSalary).max(Double::compare);

        System.out.println(op.get());

        Optional<Employee> op2 = emps.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));

        System.out.println(op2.get());
    }

    /*
     * 归约
     * reduce(T identity, BinaryOperator) / reduce(BinaryOperator)
     * ——可以将流中元素反复结合起来，得到一个值。
     */
    @Test
    public void test4() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer sum = list.stream().reduce(0, (x, y) -> x + y);

        System.out.println(sum);

        System.out.println("----------------------------------------");

        Optional<Double> op = emps.stream().map(Employee::getSalary).reduce(Double::sum);

        System.out.println(op.get());
    }


}
