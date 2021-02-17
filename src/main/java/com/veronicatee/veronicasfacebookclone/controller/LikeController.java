package com.veronicatee.veronicasfacebookclone.controller;

import com.veronicatee.veronicasfacebookclone.model.Like;
import com.veronicatee.veronicasfacebookclone.model.User;
import com.veronicatee.veronicasfacebookclone.service.LikeService;
import com.veronicatee.veronicasfacebookclone.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/like")
public class LikeController {
    PostService postService;
    LikeService likeService;

    public LikeController(PostService postService, LikeService likeService) {
        this.postService = postService;
        this.likeService = likeService;
    }

    //like post from home page
    @PostMapping("/{id}")
    public String likeIndex(@PathVariable("id") int id, HttpSession session, @Valid Like like) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/auth/login";

        like.setPost(postService.getPostById(id));
        like.setUser((User) userObj);

        if(likeService.getLike(like) != null) {
            likeService.deleteLike(like);
        } else {
            likeService.addLike(like);
        }
        return "redirect:/";
    }

    //like post from profile page
    @PostMapping("/profile/{id}")
    public String likeProfile(@PathVariable("id") int id, HttpSession session, @Valid Like like) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/auth/login";

        like.setPost(postService.getPostById(id));
        like.setUser((User) userObj);

        if(likeService.getLike(like) != null) {
            likeService.deleteLike(like);
        } else {
            likeService.addLike(like);
        }
        return "redirect:/profile";
    }


    //like post from post page
    @PostMapping("/post/{id}")
    public String likePost(@PathVariable("id") int id, HttpSession session, @Valid Like like) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/auth/login";

        like.setPost(postService.getPostById(id));
        like.setUser((User) userObj);

        if(likeService.getLike(like) != null) {
            likeService.deleteLike(like);
        } else {
            likeService.addLike(like);
        }
        return "redirect:/post/{id}";
    }
}
