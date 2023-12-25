package com.shang.canteenreviewsystemdemo.service;

import com.shang.canteenreviewsystemdemo.model.User;

import java.util.List;

public interface UserService {
    public List<User> getUserList();

    public User findByUsername(String username);

    public void save(User user);

    public void edit(User user);

    public void delete(Long id);
}
