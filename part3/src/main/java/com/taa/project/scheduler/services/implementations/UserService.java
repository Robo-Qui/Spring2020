package com.taa.project.scheduler.services.implementations;

import com.taa.project.scheduler.data.model.FreeSlot;
import com.taa.project.scheduler.data.model.Professional;
import com.taa.project.scheduler.data.model.RendezVous;
import com.taa.project.scheduler.data.model.User;
import com.taa.project.scheduler.data.repository.UserRepository;
import com.taa.project.scheduler.services.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    private final UserRepository repository;
    private ProfessionalService profService;
    private RendezVousService rdvService;

    public UserService(UserRepository repository, ProfessionalService profService, RendezVousService rdvService) {
        this.repository = repository;
        this.profService = profService;
        this.rdvService = rdvService;
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
    public RendezVous addAppointement(Long utilId, Long profId, FreeSlot slot) throws Exception {
        User util = getById(utilId);
        Professional prof = profService.getById(profId);
        if (util != null && prof != null) {
            if (prof.getFreeSlots().contains(slot)) {
                profService.removeFreeSlot(prof, slot);
                //TODO : add heading
                //return rdvService.add(new RendezVous(util, prof, slot.getStartTime(), slot.getEndTime()));
                return rdvService.add(new RendezVous());
            } else {
                throw new Exception("Slot inexistant");
            }
        } else {
            throw new Exception("Professionnel ou User not found");
        }
    }

    @Override
    public User addUser(User util) throws Exception {
        if (getByLogin(util.getLogin()) == null) {
            repository.save(util);
            return util;
        } else {
            throw new Exception("User déjà existant");
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
