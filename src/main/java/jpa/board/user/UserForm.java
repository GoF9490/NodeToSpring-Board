package jpa.board.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class UserForm {

    private String email;
    private String password;
    private String nickname;
    private Integer question;
    private String answer;
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    private LocalDateTime createDate;
}
