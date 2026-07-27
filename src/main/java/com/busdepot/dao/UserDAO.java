package com.busdepot.dao;

import com.busdepot.model.User;

public interface UserDAO {
    User login(String email, String password);
    boolean register(User user);
    boolean emailExists(String email);
    User getUserById(Integer id);
}