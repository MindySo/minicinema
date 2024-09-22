package com.minicine.minicinema.control;

import com.minicine.minicinema.dto.CommentDto;
import com.minicine.minicinema.service.comment.CommentService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
@Slf4j
public class CommentApiController {
    private final CommentService commentService;

    @PostMapping("/addComment")
    public ResponseEntity<String> addComment(
            @Valid @RequestBody CommentDto commentDto, HttpServletResponse response) throws IOException {
        try {
            System.out.println(commentDto);
            commentDto.setRegDate(LocalDateTime.now());
            commentService.insertComment(commentDto);
            return new ResponseEntity<>("inserted", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.toString());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/removeComment")
    public ResponseEntity<String> removeComment(
            @Valid @RequestBody CommentDto comment, HttpServletResponse response) throws IOException {
        try {
            System.out.println(comment);
            commentService.deleteComment(comment.getId());
            return new ResponseEntity<>("deleted", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.toString());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
