package com.shang.canteenreviewsystemdemo.controller;

import com.shang.canteenreviewsystemdemo.model.Comment;
import com.shang.canteenreviewsystemdemo.model.User;
import com.shang.canteenreviewsystemdemo.model.Dto.CommentDto;
import com.shang.canteenreviewsystemdemo.service.CanteenService;
import com.shang.canteenreviewsystemdemo.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.security.Principal;

@Controller
@RequestMapping("/")
public class CommentController {

    @Resource
    CommentService commentService;

    @Resource
    CanteenService canteenService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("canteens", canteenService.getCanteenList());
        model.addAttribute("comments", commentService.getCommentList());
        return "index";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("create", true);
        model.addAttribute("canteens", canteenService.getCanteenList());
        model.addAttribute("commentDtoForm", new CommentDto());
        return "createoredit";
    }

    @PostMapping("create")
    public String create_comment(@ModelAttribute("commentDtoForm") CommentDto commentDtoForm, Principal principal) {
        commentDtoForm.setCreatedBy(principal.getName());
        commentService.add(commentDtoForm);
        return "redirect:/";
    }

    @GetMapping("edit")
    public String edit(Model model) {
        model.addAttribute("edit", true);
        model.addAttribute("canteens", canteenService.getCanteenList());
        return "createoredit";
    }

}