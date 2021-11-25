package data.service.implementations;

import data.component.model.model.FreeSlot;
import data.component.model.model.Professional;
import data.component.model.model.RendezVous;
import data.component.model.model.User;
import data.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;
    private ProfessionalService profService;
    private RendezVousService rdvService;

    public UserService(UserRepository repository, ProfessionalService profService, RendezVousService rdvService) {
        this.repository = repository;
        this.profService = profService;
        this.rdvService = rdvService;
    }

    public User getById(Long id){
        return repository.getUserById(id);
    }

    public User getByLogin(String login){
        return repository.getUserByLogin(login);
    }

    public RendezVous addAppointement(Long utilId, Long profId, FreeSlot slot) throws Exception{
        User util = getById(utilId);
        Professional prof = profService.getById(profId);
        if(util!=null && prof!=null){
            if(prof.getFreeSlots().contains(slot)){
                profService.removeFreeSlot(prof, slot);
                return rdvService.add(new RendezVous(prof,util,slot.getStartTime(),slot.getEndTime()));
            }
            else{
                throw new Exception("Slot inexistant");
            }
        }
        else{
            throw new Exception("Professionnel ou User not found");
        }
    }

    public User addUser(User util) throws Exception {
        if(getByLogin(util.getLogin()) == null){
            repository.save(util);
            return util;
        }
        else{
            throw new Exception("User déjà existant");
        }
    }
}
