package cn.boot.onlyo.dao;

import cn.boot.onlyo.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.boot.onlyo.App;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TeacherDaoTest {

    @Autowired
    private TeacherDao teacherDao;

    @Test
    public void test1() {

        Teacher t = new Teacher("mj", "test");
        teacherDao.save(t);

    }

    @Test
    public void test2() {
        System.out.println(teacherDao.findAll());
    }

}
