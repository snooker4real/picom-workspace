package fr.snooker4real.picombusinesscaseapi.services.impl;


import fr.snooker4real.picombusinesscaseapi.entity.UserEntity;
import fr.snooker4real.picombusinesscaseapi.repository.UserRepository;
import fr.snooker4real.picombusinesscaseapi.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UtilisateurServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity recupererUserParId(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
