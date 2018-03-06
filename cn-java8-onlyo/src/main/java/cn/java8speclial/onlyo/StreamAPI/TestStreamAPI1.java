package cn.java8speclial.onlyo.StreamAPI;

import cn.java8speclial.onlyo.entity.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * （1）stream自己不会存储数据
 * （2）stream不会改变对象，相反，他们会返回一个持有结果的新stream
 * （3）stream操作是延迟执行的。这意味着他会等到需要结果的时候才会执行
 */
public class TestStreamAPI1 {

    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66),
            new Employee(101, "张三", 18, 9999.99),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 9, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55));

    /**
     * 自然排序Comparable
     * 定制排序 Comparator
     */
    @Test
    public void test5(){
        List<String> lis = Arrays.asList("ccc", "bbb", "aaa", "ddd","eee");

        lis.stream().sorted().forEach(System.out::println);

        emps.stream().sorted((e1,e2)->{
            if(e1.getAge()==e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
                return e1.getAge().compareTo(e2.getAge());
            }
        }).forEach(System.out::println);
    }

    // 2. 中间操作
    /*
     * 映射
     * map——接收 Lambda ， 将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     * flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     */
    @Test
    public void test4() {
        List<String> lis = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        lis.stream().map((str) -> str.toUpperCase()).forEach(System.out::println);

        List<Integer> a = emps.stream().map(Employee::getAge).collect(Collectors.toList());
    }

    /**
     * 筛选与切片
     * filter ---接收Lambda 从流中排出某些元素
     * limit---截断流，使其元素不超过给定数量
     * skip(n)--
     * distinct 去重
     */
    @Test
    public void test1() {
        Stream<Employee> stream = emps.stream().filter(x -> {
            System.out.println("中间操作");
            return x.getAge() > 25;
        }).distinct();
        // 终止操作
        stream.forEach(System.out::println);
    }

    @Test
    public void test2() {
        List<Employee> emp = emps.stream().distinct().collect(Collectors.toList());
    }
}
