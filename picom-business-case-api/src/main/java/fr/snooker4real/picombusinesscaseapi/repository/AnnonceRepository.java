package fr.snooker4real.picombusinesscaseapi.repository;

import fr.snooker4real.picombusinesscaseapi.entity.AnnonceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceRepository extends JpaRepository<AnnonceEntity, Long> {
}
