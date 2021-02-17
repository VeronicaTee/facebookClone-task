package com.veronicatee.veronicasfacebookclone.service;

import com.veronicatee.veronicasfacebookclone.model.Like;
import org.springframework.stereotype.Service;

@Service
public interface LikeService {
    Like addLike(Like like);
    Like getLike(Like like);
    void deleteLike(Like like);
}
