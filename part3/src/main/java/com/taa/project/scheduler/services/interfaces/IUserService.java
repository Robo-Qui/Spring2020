package com.taa.project.scheduler.services.interfaces;

import com.taa.project.scheduler.data.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();

    User getById(Long id) throws Exception;

    User getByLogin(String login);

    User addUser(User util) throws Exception;

    User updateUser(long id, User userRequest) throws Exception;

    void deleteUser(Long id) throws Exception;
}
