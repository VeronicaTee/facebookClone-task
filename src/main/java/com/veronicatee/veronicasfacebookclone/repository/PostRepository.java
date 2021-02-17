package com.veronicatee.veronicasfacebookclone.repository;

import com.veronicatee.veronicasfacebookclone.model.Post;
import com.veronicatee.veronicasfacebookclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAllByUser(User user);
    Post findByPostId(int postId);
}
