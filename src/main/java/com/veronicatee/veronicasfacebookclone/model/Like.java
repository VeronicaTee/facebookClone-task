package com.veronicatee.veronicasfacebookclone.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "likes")
//@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"user", "post"})})
public class Like implements Serializable {

    /**
     * Postfields
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int likeId;
    /*
    Like has a many to one relationship with user and post
     */
    @ManyToOne
    private User user;
    @ManyToOne
    private Post post;
}
