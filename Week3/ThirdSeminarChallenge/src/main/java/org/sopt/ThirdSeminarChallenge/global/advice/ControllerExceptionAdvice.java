package org.sopt.ThirdSeminarChallenge.global.advice;

import org.sopt.ThirdSeminarChallenge.global.ErrorStatus;
import org.sopt.ThirdSeminarChallenge.global.dto.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class ControllerExceptionAdvice {
    //필요한 값을 안넣어준 경우 400에러
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ApiResponseDto handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        return ApiResponseDto.error(ErrorStatus.VALIDATION_REQUEST_MISSING_EXCEPTION);
    }
    //없는 데이터 내용을 찾을 경우 500
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NullPointerException.class)
    protected ApiResponseDto handleNullPointerException(final NullPointerException e) {
        return ApiResponseDto.error(ErrorStatus.NULL_POINTER_INTERNAL_SERVER_EXCEPTION);
    }
    //column 조건에 만족하지 않는 데이터를 post 할 경우 500
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    protected ApiResponseDto handleSQLIntegrityConstraintViolationException(final SQLIntegrityConstraintViolationException e){
        return ApiResponseDto.error(ErrorStatus.SQL_INTERNAL_SERVER_EXCEPTION);
    }
}
