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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @Setter
    private String content;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    protected Comment() {
    }

    public static Comment createComment(User user, Board board, String content) {
        Comment comment = new Comment();
        comment.user = user;
        comment.board = board;
        comment.content = content;
        comment.createdDate = LocalDateTime.now();
        return comment;
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
