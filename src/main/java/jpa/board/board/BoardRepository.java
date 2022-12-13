package jpa.board.board;

import jpa.board.board.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;
    final int limit = 30;

    public void save(Board board) {
        em.persist(board);
    }

    public Board findOne(Long id) {
        return em.find(Board.class, id);
    }

    public List<Board> getIdFromPage(int page) {
        return em.createQuery("select b from Board b order by b.id desc", Board.class)
                .setFirstResult(limit * (page - 1))
                .setMaxResults(limit)
                .getResultList();
    }
}
