package jpa.board.service;

import jpa.board.domain.Board;
import jpa.board.domain.Comment;
import jpa.board.domain.User;
import jpa.board.repository.BoardRepository;
import jpa.board.repository.CommentRepository;
import jpa.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    public Long create(String content, Long userId, Long boardId) {
        User user = userRepository.findOne(userId);
        Board board = boardRepository.findOne(boardId);
        Comment comment = new Comment(user, board, content);
        commentRepository.save(comment);
        return comment.getId();
    }
}
