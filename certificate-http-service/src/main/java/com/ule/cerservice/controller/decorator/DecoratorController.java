package com.ule.cerservice.controller.decorator;

/**
 * Created by admin on 2018/7/10.
 */
import  org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/decorator")
public class DecoratorController {
    @RequestMapping("default")
    public String defaultDecorator() {
        return "/decorator/default";
    }
}