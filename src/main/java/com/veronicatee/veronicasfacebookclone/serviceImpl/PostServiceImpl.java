package com.veronicatee.veronicasfacebookclone.serviceImpl;

import com.veronicatee.veronicasfacebookclone.model.Like;
import com.veronicatee.veronicasfacebookclone.model.Post;
import com.veronicatee.veronicasfacebookclone.model.User;
import com.veronicatee.veronicasfacebookclone.repository.PostRepository;
import com.veronicatee.veronicasfacebookclone.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;


    /*
    Add a post
     */
    @Override
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post getPostById(int id) {
        return postRepository.findByPostId(id);
    }

    /*
    Get all user posts
     */
    @Override
    public List<Post> getPosts() {
        List<Post> posts = postRepository.findAll();
        Collections.reverse(posts);
        return posts;
    }

    /*
    Get all posts for a single user
     */
    @Override
    public List<Post> getPostsByUser(User user) {
        List<Post> posts = postRepository.findAllByUser(user);
        Collections.reverse(posts);
        return posts;
    }

    /*
    Edit a post
     */
    @Override
    public Post editPost(Post post, String messageBody) {
        post.setMessageBody(messageBody);
        return postRepository.save(post);
    }

    /*
    Delete a post
     */
    @Override
    public void deletePost(Post post) {
        postRepository.delete(post);
    }
}