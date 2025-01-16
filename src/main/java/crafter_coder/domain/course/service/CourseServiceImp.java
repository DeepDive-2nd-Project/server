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
    public CourseCreateResponse openCourse(String username, CourseCreateRequest request) {
        // username 으로 사용자 찾기 로직 -> 존재하지 않다면 예외
        // 찾은 사용자가 강사인지 확인하는 로직 -> 아니면 예외

        CourseDuration courseDuration = CourseDuration.of(request.getStartDate(), request.getEndDate());
        CourseSchedule courseSchedule = CourseSchedule.of(request.getDayOfWeek(), request.getStartTime(), request.getEndTime());
        CourseSubCategory subCategory = request.getCategory();
        EnrollmentCapacity enrollmentCapacity = EnrollmentCapacity.of(request.getCapacity());

        Course course = Course.create(request.getName(), subCategory.getCategory(), courseDuration, courseSchedule, 1L, enrollmentCapacity, request.getPrice(),
                request.getPlace(), request.getDeadline());
        Course savedCourse = courseRepository.save(course);

        return CourseCreateResponse.from(savedCourse);
    }

    @Override
    public void applyCourse(String username, CourseApplyRequest request) {
        // 사용자 조회 로직
        // 상담 조회 로직
        //조회한 상담에 대해 신청 로직


        // 신청한 순서대로 대기열에 주입

        // 대기열에 들어온 순서대로 결제 로직 처리, 만약 일정 시간 동안 결제를 하지 않거나 취소를 한다면 해당 대기열에 취소시키기

        // 결제 완료가 되었다면 신청 완료 처리
    }
}
