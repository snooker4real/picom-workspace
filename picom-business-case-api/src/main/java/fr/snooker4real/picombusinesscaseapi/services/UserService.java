package fr.snooker4real.picombusinesscaseapi.services;

import fr.snooker4real.picombusinesscaseapi.entity.UserEntity;

public interface UserService {

    UserEntity recupererUserParId(Long id);
}
