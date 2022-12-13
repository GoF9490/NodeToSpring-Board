package jpa.board.domain;

import jpa.board.controller.form.CommentForm;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Comment {

    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Setter
    private String content;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    protected Comment() {
    }

    public Comment(User user, Board board, String content) {
        this.user = user;
        this.board = board;
        this.content = content;
        this.createdDate = LocalDateTime.now();
    }

    public CommentForm toCommentForm() {
        CommentForm commentForm = new CommentForm();

        commentForm.setCommentId(id);
        commentForm.setWriter(user.getNickname());
        commentForm.setBoardId(board.getId());
        commentForm.setContent(content);
        commentForm.setCreateDate(createdDate);

        return commentForm;
    }
}
