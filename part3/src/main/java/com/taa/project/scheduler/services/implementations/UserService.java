package com.taa.project.scheduler.services.implementations;

import com.taa.project.scheduler.data.model.User;
import com.taa.project.scheduler.data.repository.UserRepository;
import com.taa.project.scheduler.services.interfaces.IProfessionalService;
import com.taa.project.scheduler.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    private final UserRepository repository;

    @Autowired
    private IProfessionalService profService;

    public UserService(UserRepository repository, ProfessionalService profService) {
        this.repository = repository;
        this.profService = profService;
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getById(Long id) {
        return repository.getUserById(id);
    }


    @Override
    public User getByLogin(String login) {
        return repository.getUserByLogin(login);
    }

    @Override
    public User addUser(User util) throws Exception {
        if (getByLogin(util.getLogin()) == null) {
            repository.save(util);
            return util;
        } else {
            throw new Exception("Utilisateur déjà existant");
        }
    }

    @Override
    public User updateUser(long id, User userRequest) throws Exception {
        User user = repository.findById(id)
                .orElseThrow(() -> new Exception("User not found"));
        user.setLogin(userRequest.getLogin());
        user.setPassword(userRequest.getPassword());
        return repository.save(user);
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        User user = repository.findById(id)
                .orElseThrow(() -> new Exception("User not found"));
        repository.delete(user);
    }
}
