package jpa.board.comment;

import jpa.board.board.Board;
import jpa.board.user.User;
import jpa.board.board.BoardRepository;
import jpa.board.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    public Long create(String content, Long userId, Long boardId) {
        User user = userRepository.findOne(userId);
        Board board = boardRepository.findOne(boardId);
        Comment comment = Comment.createComment(user, board, content);
        commentRepository.save(comment);
        return comment.getId();
    }
}
