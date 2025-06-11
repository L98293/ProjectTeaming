package Teaming.DTO.ProjectCRUD;

public record ReadProjectRequest(
        Long id,
        String title,
        String content
) {
}
