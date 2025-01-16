package crafter_coder.domain.course.service;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseApplyRequest {

    @NotNull(message = "사용자 고유 번호는 필수입니다.")
    private Long userId;
    
    @NotNull(message = "강좌 고유 번호는 필수입니다.")
    private Long courseId;
}
