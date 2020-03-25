package com.ule.cerservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author fanxunli
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
@RestController
public class TestController {

    @RequestMapping(value = "testRestful")
    public String test(HttpServletRequest request){
        String s=request.getParameter("cerinfo");
        System.out.println(s);
        return "Hello";
    }
}
