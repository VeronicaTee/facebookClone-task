package com.veronicatee.veronicasfacebookclone.service;

import com.veronicatee.veronicasfacebookclone.model.Post;
import com.veronicatee.veronicasfacebookclone.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    Post addPost (Post post);
    Post getPostById(int id);
    List<Post> getPosts ();
    List<Post> getPostsByUser(User user);
    Object editPost(Post post, String messageBody);
    void deletePost(Post post);
}
