package Teaming.teaming.DTO;



import Teaming.teaming.Entity.Profiles;

public record ProfileResponse(
        Long id,
        String major,
        String circle,
        String username
) {
    public static ProfileResponse of (Profiles profiles) {
        return new ProfileResponse(
                profiles.getId(),
                profiles.getMajor(),
                profiles.getCircle(),
                profiles.getUsername()
        );
    }
}
