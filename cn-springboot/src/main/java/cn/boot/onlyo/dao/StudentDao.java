package cn.boot.onlyo.dao;

import java.util.List;

import cn.boot.onlyo.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao {

    List<Student> likeName(String name);

    Student getById(int id);

    String getNameById(int id);

}
