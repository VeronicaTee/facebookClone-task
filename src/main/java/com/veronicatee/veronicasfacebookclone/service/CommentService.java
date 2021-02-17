package com.veronicatee.veronicasfacebookclone.service;

import com.veronicatee.veronicasfacebookclone.model.Comment;
import com.veronicatee.veronicasfacebookclone.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    Comment addComment (Comment comment);
    List<Comment> getPostComments(Post post);
    void deleteComment(Comment comment);

}
