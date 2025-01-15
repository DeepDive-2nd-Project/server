package crafter_coder.domain.course.model;

import crafter_coder.global.exception.MyErrorCode;
import crafter_coder.global.exception.MyException;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static lombok.AccessLevel.PROTECTED;

@Embeddable
@Getter
@NoArgsConstructor(access = PROTECTED)
public class CourseDuration {

    private LocalDate startDate;
    private LocalDate endDate;


    private CourseDuration(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static CourseDuration of(LocalDate startDate, LocalDate endDate) {
        if (startDate.isAfter(endDate)) {
            throw new MyException(MyErrorCode.INVALID_COURSE_DURATION);
        }

        return new CourseDuration(startDate, endDate);
    }
}
