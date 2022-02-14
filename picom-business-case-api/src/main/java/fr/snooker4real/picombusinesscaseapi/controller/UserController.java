package fr.snooker4real.picombusinesscaseapi.controller;

import fr.snooker4real.picombusinesscaseapi.entity.UserEntity;
import fr.snooker4real.picombusinesscaseapi.model.Status;
import fr.snooker4real.picombusinesscaseapi.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(UserController.class);


    @PostMapping("/register")
    public Status registerUser(@Valid @RequestBody UserEntity newUserEntity) {
        List<UserEntity> userEntities = userRepository.findAll();

        logger.info("New user : " + newUserEntity.toString());

        for (UserEntity userEntity : userEntities) {
            logger.info("Registered user : " + newUserEntity.toString());
            if (userEntity.equals(newUserEntity)) {
                logger.info("User already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }

        userRepository.save(newUserEntity);
        return Status.SUCCESS;
    }

    @PostMapping("/login")
    public Status loginUser(@Valid @RequestBody UserEntity user) {
        List<UserEntity> userEntities = userRepository.findAll();

        for (UserEntity other : userEntities) {
            if (other.equals(user)) {
                user.setLoggedIn(true);
                userRepository.save(user);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }

    @PostMapping("/logout")
    public Status logUserOut(@Valid @RequestBody UserEntity user) {
        List<UserEntity> userEntities = userRepository.findAll();

        for (UserEntity other : userEntities) {
            if (other.equals(user)) {
                user.setLoggedIn(false);
                userRepository.save(user);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }

    @DeleteMapping("/all")
    public Status deleteUsers() {
        userRepository.deleteAll();
        return Status.SUCCESS;
    }

}
