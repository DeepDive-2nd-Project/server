package crafter_coder.domain.course.model;

import crafter_coder.global.exception.MyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CourseDurationTest {

    @DisplayName("강좌 운영 기간을 설정합니다.")
    @Test
    void of() {
        // given
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        LocalDate endDate = LocalDate.of(2020, 1, 1);

        // when
        CourseDuration courseDuration = CourseDuration.of(startDate, endDate);
        // then

        assertThat(courseDuration)
                .extracting("startDate", "endDate")
                .contains(startDate, endDate);
    }

    @DisplayName("강좌 시작 날짜는 종료 날짜보다 이전이어야 합니다.")
    @Test
    void ofException() {
        // given
        LocalDate startDate = LocalDate.of(2020, 1, 5);
        LocalDate endDate = LocalDate.of(2020, 1, 2);

        // when & then

        assertThatThrownBy(() -> CourseDuration.of(startDate, endDate))
                .isInstanceOf(MyException.class)
                .hasMessage("강좌의 시작 날짜는 종료 날짜보다 이전이어야 합니다.");
    }


}