package cn.boot.onlyo.service;

import cn.boot.onlyo.dao.TeacherDao;
import cn.boot.onlyo.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherSerivceImp implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    public List<Teacher> findteaTime() {
        // teacherDao.f
        return null;
    }
}
