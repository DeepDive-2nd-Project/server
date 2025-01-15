package crafter_coder.domain.course.model.category;

import crafter_coder.global.exception.MyErrorCode;
import crafter_coder.global.exception.MyException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum CourseSubCategory {
    // 교양
    HUMANITIES_ART(CourseCategory.CULTURE, "인문예술"),
    INVESTMENT(CourseCategory.CULTURE, "재테크"),
    // 취미
    COOKING(CourseCategory.HOBBY, "쿠킹"),
    PHOTOGRAPHY(CourseCategory.HOBBY, "사진"),
    PAINTING(CourseCategory.HOBBY, "미술"),
    // 외국어
    ENGLISH(CourseCategory.LANGUAGE, "영어"),
    JAPANESE(CourseCategory.LANGUAGE, "일본어"),
    // 육아
    MOM_AND_BABY(CourseCategory.PARENTING, "엄마랑 아가랑"),
    CHILD_EDUCATION(CourseCategory.PARENTING, "자녀교육"),
    ;

    private final CourseCategory category; // 상위 카테고리
    private final String description; // 한글 표현

    public static CourseSubCategory getSubCategoryBy(String description) {
        return Arrays.stream(CourseSubCategory.values())
                .filter(category -> category.getDescription().equals(description))
                .findFirst().orElseThrow(() -> new MyException(MyErrorCode.NOT_FOUND_COURSE_CATEGORY));
    }
}
