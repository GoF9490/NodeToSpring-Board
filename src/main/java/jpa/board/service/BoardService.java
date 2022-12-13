package jpa.board.service;

import jpa.board.domain.Board;
import jpa.board.domain.User;
import jpa.board.repository.BoardRepository;
import jpa.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long create(Board board, Long userId) {
        User user = userRepository.findOne(userId);
        board.setUser(user);
        boardRepository.save(board);
        return  board.getId();
    }

    public Board findOne(Long id) {
        return boardRepository.findOne(id);
    }

    public List<Board> getListFromPage(int page) {
        return boardRepository.getIdFromPage(page);
    }

    @Transactional
    private Long update() {
        return null;
    }

    @Transactional
    private Long delete() {
        return null;
    }
}
