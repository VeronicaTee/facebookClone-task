package com.veronicatee.veronicasfacebookclone.repository;

import com.veronicatee.veronicasfacebookclone.model.Like;
import com.veronicatee.veronicasfacebookclone.model.Post;
import com.veronicatee.veronicasfacebookclone.model.User;
import org.springframework.data.repository.CrudRepository;

public interface LikeRepository extends CrudRepository <Like, Integer> {
    Like findByUserAndPost(User user, Post post);
}
