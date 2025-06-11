package Teaming.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Teaming.Domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
