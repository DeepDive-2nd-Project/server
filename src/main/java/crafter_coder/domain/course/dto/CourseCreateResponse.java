package crafter_coder.domain.course.dto;

import crafter_coder.domain.course.model.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseCreateResponse {
    private Long id;

    public static CourseCreateResponse from(Course course) {
        return new CourseCreateResponse(course.getId());
    }
}
