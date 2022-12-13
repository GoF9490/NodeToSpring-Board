package jpa.board.service;

import jpa.board.domain.Board;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardService {
    Long create(Board board, Long userId);
    Board findOne(Long id);
    List<Board> getListFromPage(int page);
    Long update();
    Long delete();
}
