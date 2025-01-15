package crafter_coder.domain.course.service;

import crafter_coder.domain.course.CourseRepository;
import crafter_coder.domain.course.dto.CourseCreateRequest;
import crafter_coder.domain.course.dto.CourseCreateResponse;
import crafter_coder.domain.course.model.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImp implements CourseService {
    private final CourseRepository courseRepository;


    @Override
    public CourseCreateResponse createCourse(String username, CourseCreateRequest request) {
        // username 으로 사용자 찾기 로직
        return null;
    }
}
