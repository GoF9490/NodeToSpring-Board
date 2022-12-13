package jpa.board.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/board/{boardId}/new-comment")
    public ResponseEntity<Object> newComment(
            @RequestBody @Valid CommentForm commentForm,
            @PathVariable("boardId") Long boardId) {
        commentService.create(commentForm.getContent(), commentForm.getUserId(), boardId);

        URI uri = URI.create("/board/" + boardId);
        return ResponseEntity.created(uri).build();
    }
}
