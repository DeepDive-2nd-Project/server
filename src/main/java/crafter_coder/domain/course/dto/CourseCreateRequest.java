package crafter_coder.domain.course.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseCreateRequest {
    @NotBlank(message = "강좌 제목은 필수입니다.")
    private String name;

    @NotBlank(message = "강좌 카테고리는 필수입니다.")
    private String category;

    @Min(value = 1, message = "최대 정원은 양수입니다.")
    private int capacity;

    @PositiveOrZero(message = "금액은 0원 이상 입니다.")
    private int price;

    @NotBlank(message = "강좌 위치는 필수입니다.")
    private String place;

    @NotNull(message = "주어진 startDate 이 없습니다.")
    @Future(message = "현재보다 미래 날짜이어야 합니다.")
    private LocalDate startDate;

    @NotNull(message = "주어진 endDate 이 없습니다.")
    @Future(message = "현재보다 미래 날짜이어야 합니다.")
    private LocalDate endDate;

    @NotNull(message = "요일은 필수입니다.")
    private DayOfWeek dayOfWeek;

    @NotNull(message = "주어진 startTime 이 없습니다.")
    private LocalTime startTime;

    @NotNull(message = "주어진 startTime 이 없습니다.")
    private LocalTime endTime;

    @NotNull(message = "주어진 deadline 이 없습니다.")
    @Future(message = "현재보다 미래 날짜이어야 합니다.")
    private LocalDate deadline;
}
