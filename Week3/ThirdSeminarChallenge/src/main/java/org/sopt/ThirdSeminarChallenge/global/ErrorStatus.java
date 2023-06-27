package org.sopt.ThirdSeminarChallenge.global;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorStatus {

    /*
    BAD_REQUEST
     */
    VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    VALIDATION_REQUEST_MISSING_EXCEPTION(HttpStatus.BAD_REQUEST, "요청값이 입력되지 않았습니다."),


    /*
    CONFLICT
     */
    CONFLICT_EMAIL_EXCEPTION(HttpStatus.CONFLICT, "이미 등록된 이메일입니다."),
    CONFLICT_NICKNAME_EXCEPTION(HttpStatus.CONFLICT, "이미 등록된 닉네임입니다."),

    /*
    SERVER_ERROR
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "예상치 못한 서버 에러가 발생했습니다."),
    BAD_GATEWAY_EXCEPTION(HttpStatus.BAD_GATEWAY, "일시적인 에러가 발생하였습니다.\n잠시 후 다시 시도해주세요!"),
    SERVICE_UNAVAILABLE_EXCEPTION(HttpStatus.SERVICE_UNAVAILABLE, "현재 점검 중입니다.\n잠시 후 다시 시도해주세요!"),
    //새로 추가 테스트 후 발생할 수 있는 에러 추가
    SQL_INTERNAL_SERVER_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "중복된 값이 존재하거나 전달하지 않은 데이터가 있습니다."),
    NULL_POINTER_INTERNAL_SERVER_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "해당하는 데이터가 존재하지 않습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}