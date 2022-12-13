package jpa.board.controller.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class BoardForm {

    private Long boardId;
    private Long userId;
    private String title;
    private String writer;
    private String content;
    private List<CommentForm> comments = new ArrayList<>();
    private Integer commentCount;
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    private LocalDateTime createDate;
}
