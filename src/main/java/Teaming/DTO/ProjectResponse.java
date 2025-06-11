package Teaming.DTO;

import Teaming.Domain.Project;

public record ProjectResponse(
        Long id,
        String title,
        String content
) {

    public static ProjectResponse of(Project project) {
        return new ProjectResponse(
                project.getId(),
                project.getTitle(),
                project.getContent()
        );
    }
}
