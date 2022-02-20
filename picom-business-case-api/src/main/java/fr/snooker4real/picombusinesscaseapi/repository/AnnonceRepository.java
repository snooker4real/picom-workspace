package fr.snooker4real.picombusinesscaseapi.repository;

import fr.snooker4real.picombusinesscaseapi.entity.AnnonceEntity;
import fr.snooker4real.picombusinesscaseapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnonceRepository extends JpaRepository<AnnonceEntity, Long> {

    List<AnnonceEntity> findByUser(UserEntity user);

}
