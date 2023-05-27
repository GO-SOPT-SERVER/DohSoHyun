package sopt.org.fourthSeminar.config.resolver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) //어노테이션이 파라미터에서 사용
@Retention(RetentionPolicy.RUNTIME) //프로그램이 실행되는 동안 어노테이션 유호
public @interface UserId {
}
