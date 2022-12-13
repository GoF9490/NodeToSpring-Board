package jpa.board.board;

import jpa.board.board.Board;

import java.util.List;

public interface BoardService {
    Long create(Long userId, String title, String content);
    Board findOne(Long id);
    List<Board> getListFromPage(int page);
    Long update();
    Long delete();
}
