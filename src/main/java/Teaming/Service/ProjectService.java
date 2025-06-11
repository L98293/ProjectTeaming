package Teaming.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import Teaming.DTO.ProjectCRUD.CreateProjectRequest;
import Teaming.DTO.ProjectCRUD.DeleteProjectRequest;
import Teaming.DTO.ProjectCRUD.ReadProjectRequest;
import Teaming.DTO.ProjectCRUD.UpdateProjectRequest;
import Teaming.Domain.Project;
import Teaming.Repository.ProjectRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    // CRUD중 C(프로젝트 작성)
    public void createProject(CreateProjectRequest request) {
        Project post = Project.builder()
                .title(request.title())
                .content(request.content())
                .build();
        projectRepository.save(post);
    }

    // CRUD중 R(프로젝트 상세보기)
    public List<ReadProjectRequest> getProjects() {
        return projectRepository.findAll()
                .stream()
                .map(project
                        -> new ReadProjectRequest(project.getId(), project.getTitle(), project.getContent()))
                .collect(Collectors.toList());
    }

    // CRUD중 U(프로젝트 수정)
    public Project updateProject(Long id, UpdateProjectRequest request) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 프로젝트 입니다."));
        project.setTitle(request.title());
        project.setContent(request.content());

        return projectRepository.save(project);
    }

    // CRUD중 D(프로젝트 삭제)
    public void deleteProject(DeleteProjectRequest request) {
        Project p = projectRepository.findById(request.id()).orElseThrow(()
                -> new IllegalArgumentException("존재하지 않는 프로젝트 입니다."));
        projectRepository.delete(p);
    }
}
