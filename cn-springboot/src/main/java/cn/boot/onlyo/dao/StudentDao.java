package cn.boot.onlyo.dao;

import java.util.List;

import cn.boot.onlyo.entity.Student;

public interface StudentDao {

    List<Student> likeName(String name);

    Student getById(int id);

    String getNameById(int id);

}
