package Teaming.teaming.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import Teaming.teaming.Service.DecoService;
import Teaming.teaming.DTO.CreateDecoRequest;
import Teaming.teaming.DTO.ProfileResponse;
import Teaming.teaming.DTO.UpdateProfiles;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class DecoController {
    private final DecoService decoService;

    @PostMapping()
    public void createDeco(@RequestBody CreateDecoRequest request) {
        decoService.createDeco(request);
    }


    @GetMapping("/{id}")
    public ProfileResponse findProfilesById(@PathVariable Long id) {
        return decoService.findProfilesById(id);
    }

    @PatchMapping()
    public ProfileResponse updateProfiles(@RequestBody UpdateProfiles request) {
        return decoService.updateProfiles(request);
    }

    //    @GetMapping("/search")
//    public ProfileResponse findProfilesByMajor(@RequestParam  UpdateProfiles request) {
//        return decoService.findProfilesByMajor(major);
//    }
//데코 서비스에서 쓸 전공으로 프로필 찾기
    @GetMapping()
    public List<ProfileResponse> findAll() {
        return decoService.findAll();
    }
}
