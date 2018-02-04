package cn.boot.onlyo.dao;

import cn.boot.onlyo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.boot.onlyo.App;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDaoTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void likeName() throws Exception {
        List<Student> s = studentDao.likeName("ma");
        System.out.println(s);
    }

    @Test
    public void getById() throws Exception {
    }

    @Test
    public void getNameById() throws Exception {
    }

}
