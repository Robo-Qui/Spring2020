package services.interfaces;

import data.model.FreeSlot;
import data.model.RendezVous;
import data.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    
    User getById(Long id);

    User getByLogin(String login);

    RendezVous addAppointement(Long utilId, Long profId, FreeSlot slot) throws Exception;

    User addUser(User util) throws Exception;

    User updateUser(long id, User userRequest) throws Exception;

    void deleteUser(Long id) throws Exception;
}
