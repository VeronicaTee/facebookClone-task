package com.veronicatee.veronicasfacebookclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "comments")
public class Comment {

    /**
     * Comment fields
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int commentId;
    /**
    Comment has a many to one relationship with user and post
     */
    @ManyToOne
    private User user;
    @ManyToOne
    private Post post;

    @NotBlank(message = "comment body is required")
    private String commentBody;
}
