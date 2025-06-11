package Teaming.DTO.ProjectCRUD;

public record UpdateProjectRequest(
        Long id,
        String title,
        String content
) {
}
