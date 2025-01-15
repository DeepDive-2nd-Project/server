package crafter_coder.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MyErrorCode {
    // 아래는 예시이니 필요하다면 변경 혹은 삭제해도 괜찮습니다.
    // User
     USER_NOT_FOUND(HttpStatus.NOT_FOUND,"존재하지 않는 유저입니다."),

    //Image
    NOT_GENERATE_FIRE_AI_IMAGE(HttpStatus.BAD_REQUEST,"횃불이 이미지가 생성 중 입니다."),

    // Course
    NOT_FOUND_COURSE_CATEGORY(HttpStatus.NOT_FOUND, "존재하지 않는 카테고리입니다."),

    // CourseDuration
    INVALID_COURSE_DURATION(HttpStatus.UNPROCESSABLE_ENTITY, "강좌의 시작 날짜는 종료 날짜보다 이전이어야 합니다."),
    ;

    private final HttpStatus status;
    private final String message;
}

