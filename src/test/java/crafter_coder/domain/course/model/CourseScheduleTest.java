package crafter_coder.domain.course.model;

import crafter_coder.global.exception.MyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CourseScheduleTest {

    @DisplayName("강좌 운영 기간을 설정합니다.")
    @Test
    void of() {
        // given
        DayOfWeek dayOfWeek = DayOfWeek.FRIDAY;
        LocalTime startTime = LocalTime.of(13, 0, 0);
        LocalTime endTime = LocalTime.of(15, 0, 0);

        // when
        CourseSchedule courseDuration = CourseSchedule.of(dayOfWeek, startTime, endTime);
        // then

        assertThat(courseDuration)
                .extracting("dayOfWeek", "startTime", "endTime")
                .contains(dayOfWeek, startTime, endTime);
    }

    @DisplayName("강좌 시작 날짜는 종료 날짜보다 이전이어야 합니다.")
    @Test
    void ofException() {
        // given
        DayOfWeek dayOfWeek = DayOfWeek.FRIDAY;
        LocalTime startTime = LocalTime.of(15, 0, 30);
        LocalTime endTime = LocalTime.of(15, 0, 29);

        // when & then

        assertThatThrownBy(() -> CourseSchedule.of(dayOfWeek, startTime, endTime))
                .isInstanceOf(MyException.class)
                .hasMessage("강좌의 시작 시간은 종료 시간보다 이전이어야 합니다.");
    }


}