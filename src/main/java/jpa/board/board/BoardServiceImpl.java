package jpa.board.board;

import jpa.board.user.User;
import jpa.board.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long create(Long userId, String title, String content) {
        User user = userRepository.findOne(userId);
        Board board = Board.createBoard(user, title, content);
        boardRepository.save(board);
        return board.getId();
    }

    public Board findOne(Long id) {
        return boardRepository.findOne(id);
    }

    public List<Board> getListFromPage(int page) {
        return boardRepository.getIdFromPage(page);
    }

    @Transactional
    public Long update() {
        return null;
    }

    @Transactional
    public Long delete() {
        return null;
    }
}
