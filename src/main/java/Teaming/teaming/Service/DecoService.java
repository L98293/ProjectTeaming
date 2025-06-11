package Teaming.teaming.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import Teaming.teaming.Entity.Profiles;
import Teaming.teaming.DTO.CreateDecoRequest;
import Teaming.teaming.DTO.ProfileResponse;
import Teaming.teaming.DTO.UpdateProfiles;
import Teaming.teaming.Repository.MajorRepository;
import Teaming.teaming.Repository.ProfilesRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class DecoService {
    private final ProfilesRepository ProfilesRepository;

    public void createDeco(CreateDecoRequest request) {
        Profiles profiles = Profiles.builder()
                .major(request.major())
                .circle(request.circle())
                .username(request.username())
                .build();

        ProfilesRepository.save(profiles);
    }
    public ProfileResponse findProfilesById(Long id) {
        Profiles e = ProfilesRepository.findById(id).orElse(null);
        if (e == null) {
            throw new IllegalArgumentException(id +"는 없는 프로필입니다.");
        }

        return ProfileResponse.of(e);
    }

    public ProfileResponse updateProfiles(UpdateProfiles request) {
        Profiles e = ProfilesRepository.findById(request.id()).orElse(null);
        if (e == null) {
            throw new IllegalArgumentException(request.id() +"는 없는 프로필입니다.");
        }
        e.setMajor(request.major());
        e.setCircle(request.circle());
        e.setUsername(request.username());
        ProfilesRepository.save(e);

        return ProfileResponse.of(e);
    }

    //    public ProfileResponse findProfilesByMajor(UpdateProfiles request) {
//        Profiles e = MajorRepository.findByMajor(request.major()).orElse(null);
//        if (e == null) {
//            throw new IllegalArgumentException(request.major() +"는 없는 프로필입니다.");
//        }
//        return ProfileResponse.of(e);
//    }
// 전공으로 사람찾기
    public List<ProfileResponse> findAll() {
        return ProfilesRepository.findAll().stream().map(ProfileResponse::of).collect(Collectors.toList());
    }
}
