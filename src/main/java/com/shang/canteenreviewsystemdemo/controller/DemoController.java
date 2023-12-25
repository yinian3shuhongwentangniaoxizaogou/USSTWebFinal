package com.shang.canteenreviewsystemdemo.controller;

import com.shang.canteenreviewsystemdemo.service.CanteenService;
import com.shang.canteenreviewsystemdemo.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.Resource;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private CommentService commentService;

    @Resource
    private CanteenService canteenService;

    @GetMapping("/create")
    public String create() {
        return "createoredit";
    }
}
