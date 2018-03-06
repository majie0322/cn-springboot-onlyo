package cn.java8speclial.onlyo.StreamAPI;

import cn.java8speclial.onlyo.entity.Employee;
import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestStreamAPI7 {

    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 79, 6666.66, Employee.Status.BUSY),
            new Employee(101, "张三", 18, 9999.99, Employee.Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Employee.Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Employee.Status.BUSY));

    /**
     * 查找与匹配
     *  -- allMatch
     *  -- anyMatch
     *  -- noneMatch
     *  -- findFirst
     *  -- findAny
     *
     *  cout
     *  max
     *  min
     *
     */
    @Test
    public void test1(){
        Boolean b1 = emps.stream().allMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);

        boolean b2 = emps.stream().anyMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b2);

        boolean b3 = emps.stream().noneMatch(e -> e.getStatus().equals(Employee.Status.NONE));
        System.out.println(b3);

        //可以为空 用这个类型
        Optional<Employee> e = emps.stream().findFirst();
        System.out.println(e.get());

        System.out.println(emps.stream().findAny().get());
    }

    @Test
    public void test2(){
        Long a = emps.stream().count();

        Employee e = emps.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).get();
        System.out.println(e);

        Employee el = emps.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).get();
        System.out.println(el);
    }
}
