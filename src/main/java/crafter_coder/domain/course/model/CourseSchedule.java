package crafter_coder.domain.course.model;

import crafter_coder.global.exception.MyErrorCode;
import crafter_coder.global.exception.MyException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;

import static jakarta.persistence.EnumType.STRING;
import static lombok.AccessLevel.PROTECTED;

@Embeddable
@Getter
@NoArgsConstructor(access = PROTECTED)
public class CourseSchedule {
    @Column(nullable = false)
    @Enumerated(value = STRING)
    private DayOfWeek dayOfWeek;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    private CourseSchedule(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;

    }

    public static CourseSchedule of(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        if (startTime.isAfter(endTime)) {
            throw new MyException(MyErrorCode.INVALID_COURSE_SCHEDULE);
        }
        return new CourseSchedule(dayOfWeek, startTime, endTime);
    }
}
