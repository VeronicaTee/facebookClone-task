package com.veronicatee.veronicasfacebookclone.service;

import com.veronicatee.veronicasfacebookclone.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void addUser (User user);
    User getUserById(int id);
    User getUserByEmail(String email);
    User getUserByEmailAndPassword(String email, String password);
    boolean deleteUser(User user);

}
