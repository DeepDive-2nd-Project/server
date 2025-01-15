package crafter_coder.domain.course.service;

import crafter_coder.domain.course.CourseRepository;
import crafter_coder.domain.course.dto.CourseCreateRequest;
import crafter_coder.domain.course.dto.CourseCreateResponse;
import crafter_coder.domain.course.model.Course;
import crafter_coder.domain.course.model.CourseDuration;
import crafter_coder.domain.course.model.CourseSchedule;
import crafter_coder.domain.course.model.EnrollmentCapacity;
import crafter_coder.domain.course.model.category.CourseSubCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImp implements CourseService {
    private final CourseRepository courseRepository;


    @Override
    public CourseCreateResponse createCourse(String username, CourseCreateRequest request) {
        // username 으로 사용자 찾기 로직 -> 존재하지 않다면 예외
        // 찾은 사용자가 강사인지 확인하는 로직 -> 아니면 예외

        CourseDuration courseDuration = CourseDuration.of(request.getStartDate(), request.getEndDate());
        CourseSchedule courseSchedule = CourseSchedule.of(request.getDayOfWeek(), request.getStartTime(), request.getEndTime());
        //CourseSubCategory subCategoryBy = CourseSubCategory.getSubCategoryBy(request.getCategory());
        CourseSubCategory subCategory = request.getCategory();
        EnrollmentCapacity enrollmentCapacity = EnrollmentCapacity.of(request.getCapacity());

        Course course = Course.create(request.getName(), subCategory.getCategory(), courseDuration, courseSchedule, 1L, enrollmentCapacity, request.getPrice(),
                request.getPlace(), request.getDeadline());
        Course savedCourse = courseRepository.save(course);

        return CourseCreateResponse.from(savedCourse);
    }
}
