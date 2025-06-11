package Teaming.Domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message; // 신청할 때 쓰는 한마디

    private boolean accepted; // 수락 여부

    @ManyToOne
    private Member applicant; // 신청자

    @ManyToOne
    private Project project; // 어떤 프로젝트에 신청했는지
}
