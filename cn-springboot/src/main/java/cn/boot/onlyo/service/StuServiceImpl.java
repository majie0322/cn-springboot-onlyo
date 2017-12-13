package cn.boot.onlyo.service;

import java.util.List;

import cn.boot.onlyo.dao.StudentDao;
import cn.boot.onlyo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> likeName(String name) {
        return studentDao.likeName(name);
    }

}
