package jpa.board.domain;

import jpa.board.controller.form.BoardForm;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
public class Board {

    @Id
    @GeneratedValue
    @Column(name = "board_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String title;
    private String content;

    @Column(name = "created_date")
    @Setter(AccessLevel.NONE)
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "board")
    private List<Comment> comments = new ArrayList<>();


    protected Board() {}

    public Board(User user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.createdDate = LocalDateTime.now();
    }

    public BoardForm toBoardForm(boolean needComment) {
        BoardForm boardForm = new BoardForm();

        boardForm.setBoardId(id);
        boardForm.setWriter(user.getNickname());
        boardForm.setTitle(title);
        boardForm.setContent(content);
        boardForm.setCommentCount(comments.size());
        boardForm.setCreateDate(createdDate);
        if (needComment) {
            boardForm.setComments(comments.stream()
                    .map(Comment::toCommentForm)
                    .collect(Collectors.toList()));
        }
        return boardForm;
    }
}
