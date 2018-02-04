package cn.boot.onlyo.shiro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {

    @RequestMapping("login")
    public String test1() {
        return "WEB-INF/login.jsp";
    }
}
