package com.veronicatee.veronicasfacebookclone.serviceImpl;

import com.veronicatee.veronicasfacebookclone.model.Like;
import com.veronicatee.veronicasfacebookclone.repository.LikeRepository;
import com.veronicatee.veronicasfacebookclone.service.LikeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeRepository likeRepository;

    /*
    Like a post
     */
    @Override
    public Like addLike(Like like) {
        return likeRepository.save(like);
    }

    @Override
    public Like getLike(Like like) {
        return likeRepository.findByUserAndPost(like.getUser(), like.getPost());
    }


    /*
    Unlike a post
     */
    @Override
    public void deleteLike(Like like) {
        likeRepository.delete(like);
    }
}