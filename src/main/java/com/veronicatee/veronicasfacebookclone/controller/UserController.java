package com.veronicatee.veronicasfacebookclone.controller;


import com.veronicatee.veronicasfacebookclone.model.Comment;
import com.veronicatee.veronicasfacebookclone.model.Like;
import com.veronicatee.veronicasfacebookclone.model.Post;
import com.veronicatee.veronicasfacebookclone.model.User;
import com.veronicatee.veronicasfacebookclone.repository.UserRepository;
import com.veronicatee.veronicasfacebookclone.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    PostService postService;

    public UserController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/profile")
    public String getPosts(Model model, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/auth/login";
        model.addAttribute("user", (User) userObj);
        model.addAttribute("userposts", postService.getPostsByUser((User) userObj));
        model.addAttribute("newpost", new Post());
        model.addAttribute("postupdate", new Post());
        model.addAttribute("postdelete", new Post());
        model.addAttribute("newcomment", new Comment());
        model.addAttribute("newpostlike", new Like());
        return "profile";
    }

//    private UserService userService;
//    private UserRepository userRepository;


//    @Autowired
//    public UserController ( UserRepository userRepository) {
////        this.userService = userService;
//        this.userRepository = userRepository;
//
//    }

//    @GetMapping("/")
//    public String viewUser (@ModelAttribute("foundUser") User foundUser, Model model){
//        List<User> userList = userRepository.findAll();
//        if (userList.size()!=0){
//            model.addAttribute("users", userList.get(0));
//            return "home";
//        }
//        User user = new User();
//        user.setFirstname("no name saved yet");
//        user.setLastname("no name saved yet");
//        model.addAttribute("users", user);
//        return "homePage";
//
//    }
}
