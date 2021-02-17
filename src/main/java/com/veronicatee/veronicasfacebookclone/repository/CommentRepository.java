package com.veronicatee.veronicasfacebookclone.repository;

import com.veronicatee.veronicasfacebookclone.model.Comment;
import com.veronicatee.veronicasfacebookclone.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CommentRepository extends CrudRepository <Comment, Integer> {
    List<Comment> findAllByPost(Post post);
}




