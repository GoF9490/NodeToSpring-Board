package jpa.board.service;

public interface CommentService {
    Long create(String content, Long userId, Long boardId);
}
