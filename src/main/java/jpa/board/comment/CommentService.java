package jpa.board.comment;

public interface CommentService {
    Long create(String content, Long userId, Long boardId);
}
