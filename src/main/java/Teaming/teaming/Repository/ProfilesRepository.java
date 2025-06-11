package Teaming.teaming.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import Teaming.teaming.Entity.Profiles;

import java.util.Optional;

public interface ProfilesRepository extends JpaRepository<Profiles, Long> {
    Optional<Profiles> findById(Long id);
}