package cn.boot.onlyo.controller;

import java.util.List;

import cn.boot.onlyo.entity.Student;
import cn.boot.onlyo.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StuController {

    @Autowired
    private StuService stuService;

    @RequestMapping("/likeName")
    // 返回json的字符串
    @ResponseBody
    public List<Student> likename(String name) {
        return stuService.likeName(name);
    }

}
