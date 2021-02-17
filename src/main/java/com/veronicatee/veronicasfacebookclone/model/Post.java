package com.veronicatee.veronicasfacebookclone.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "posts")
public class Post {
    /**
     * Post fields
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int postId;

    //Post has a many to one relationship with user
    @ManyToOne
    private User user;

    @NotBlank(message = "First name is required")
    private String messageBody;

    /*
    Post has a one to many relationship with like and comment
     */
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Like> likes = new ArrayList<>();
}
