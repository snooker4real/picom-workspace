package fr.snooker4real.picombusinesscaseapi.repository;

import fr.snooker4real.picombusinesscaseapi.entity.Role;
import fr.snooker4real.picombusinesscaseapi.model.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

}
