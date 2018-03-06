package cn.java8speclial.onlyo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Student {

    private String id;

    private String name;

    public static void main(String[] args) {
        Student s =  new Student();
        s.getId();
    }
}
