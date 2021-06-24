package com.unit.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: unit-test
 * @description:
 * @author: hu_pf
 * @create: 2021-06-24 14:23
 **/
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model){

        model.addAttribute("msg","Hello!!");

        return "hello";
    }
}
