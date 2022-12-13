package jpa.board.controller;

import jpa.board.controller.form.BoardForm;
import jpa.board.domain.Board;
import jpa.board.service.BoardService;
import jpa.board.service.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/board/new")
    public ResponseEntity<Object> newBoard(
            @RequestBody @Valid BoardForm boardForm) {

        Board board = new Board(
                null,
                boardForm.getTitle(),
                boardForm.getContent());

        Long boardId = boardService.create(board, boardForm.getUserId());
        URI uri = URI.create("/board/" + boardId);
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/board/{boardId}")
    public BoardForm getBoard(
            @PathVariable("boardId") String pathVariable) {

        Long boardId = Long.parseLong(pathVariable);
        return boardService.findOne(boardId).toBoardForm(true);
    }

    @GetMapping("/board")
    public List<BoardForm> getPage(
            @RequestParam(name = "page", defaultValue = "1") int page) {

        return boardService.getListFromPage(page).stream()
                .map(board -> board.toBoardForm(false))
                .collect(Collectors.toList());
    }
}
