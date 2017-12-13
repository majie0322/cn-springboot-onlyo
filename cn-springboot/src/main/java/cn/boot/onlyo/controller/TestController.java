package cn.boot.onlyo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("hello")
    public String index(){
        return "hello word";
    }
}
