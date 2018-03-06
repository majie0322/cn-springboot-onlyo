package cn.java8speclial.onlyo.StreamAPI;

import cn.java8speclial.onlyo.entity.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestStreamAPI5 {

    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66),
            new Employee(101, "张三", 18, 9999.99),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 9, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55));

    
    // 映射 -- 接受lambda，将元素转换成其他形式或提取信息，接收一个函数作为参数 该函数会被应用到每个元素并将其映射成一个新的元素
    // flatMap -- 接收一个函数作为参数，将流中的每个值都转换成另一个流，然后把所有流连接成一个流
    @Test
    public void test1() {
        List<String> lis = Arrays.asList("aaa", "bbbb", "ccc");
        lis.stream().map(x -> x.toUpperCase()).forEach(System.out::println);

        emps.stream().map(Employee::getName).forEach(System.out::println);

 /*       Stream<Stream<Character>> stream = lis.stream().map(TestStreamAPI5::filterCharacter);
        stream.forEach(x->x.forEach(System.out::println));
*/
        lis.stream().flatMap(TestStreamAPI5::filterCharacter).forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> lis = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            lis.add(ch);
        }

        return lis.stream();
    }



}
