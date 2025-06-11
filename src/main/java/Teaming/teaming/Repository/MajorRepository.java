package Teaming.teaming.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Teaming.teaming.Entity.Profiles;

import java.util.Optional;

public interface MajorRepository extends JpaRepository<Profiles, String> {
    Optional<Profiles> findByMajor(String major);
}
//전공 레포지토리 만들기