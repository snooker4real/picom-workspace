package fr.snooker4real.picombusinesscaseapi.repository;

import fr.snooker4real.picombusinesscaseapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
