package com.veronicatee.veronicasfacebookclone.serviceImpl;

import com.veronicatee.veronicasfacebookclone.model.Comment;
import com.veronicatee.veronicasfacebookclone.model.Post;
import com.veronicatee.veronicasfacebookclone.repository.CommentRepository;
import com.veronicatee.veronicasfacebookclone.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    /*
    Add comment to a post
     */
    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    /*
    Get all comments for a post
     */
    @Override
    public List<Comment> getPostComments(Post post) {
        return commentRepository.findAllByPost(post);
    }

    /*
    Delete a comment
     */
    @Override
    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }
}