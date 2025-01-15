package crafter_coder.domain.course.service;

import crafter_coder.domain.course.dto.CourseCreateRequest;
import crafter_coder.domain.course.dto.CourseCreateResponse;

public interface CourseService {

    CourseCreateResponse createCourse(String username, CourseCreateRequest request);
}
