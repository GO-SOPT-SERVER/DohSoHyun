package sopt.org.fourthSeminar.controller.dto.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class BoardRequestDto {
//
//    @Email(message = "이메일 형식에 맞지 않습니다")
//    private String email;
    @NotNull
    private List<MultipartFile> boardImages;
    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    private Boolean isPublic;
}
