package com.veronicatee.veronicasfacebookclone.controller;

import com.veronicatee.veronicasfacebookclone.model.Comment;
import com.veronicatee.veronicasfacebookclone.model.Like;
import com.veronicatee.veronicasfacebookclone.model.Post;
import com.veronicatee.veronicasfacebookclone.model.User;
import com.veronicatee.veronicasfacebookclone.service.PostService;
import com.veronicatee.veronicasfacebookclone.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class IndexController {
    PostService postService;

    public IndexController(PostService postService) {
        this.postService = postService;
    }

    //get mapping for populating home page
    @GetMapping("/")
    public String getPosts(Model model, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/login";

        model.addAttribute("user", (User) userObj);

        model.addAttribute("posts", postService.getPosts());


        model.addAttribute("newpost", new Post());
        model.addAttribute("newcomment", new Comment());
        model.addAttribute("newlike", new Like());

        return "index";
    }
}
