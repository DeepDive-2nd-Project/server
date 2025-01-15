package crafter_coder.domain.course.controller;

import crafter_coder.domain.course.dto.CourseCreateRequest;
import crafter_coder.domain.course.dto.CourseCreateResponse;
import crafter_coder.domain.course.service.CourseService;
import crafter_coder.global.dto.ResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<ResponseDto<CourseCreateResponse>> createCourse(String username, @Valid @RequestBody CourseCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED.value())
                .body(ResponseDto.of(courseService.createCourse(username, request), "강좌 개설"));
    }
}
