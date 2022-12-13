package jpa.board.comment;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class CommentForm {

    private Long commentId;
    private Long boardId;
    private Long userId;
    private String writer;
    private String content;
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    private LocalDateTime createDate;
}
