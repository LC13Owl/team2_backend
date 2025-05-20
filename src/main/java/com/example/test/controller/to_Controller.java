package com.example.test.controller;

import com.example.test.dto.BoardDto;
import com.example.test.dto.DtoExceptContent;
import com.example.test.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class to_Controller {

    @Autowired
    private BoardService boardService;

    // 글 작성
    @PostMapping()
    public void createBoard(@RequestBody BoardDto boardDto) {
        boardService.saveBoard(boardDto);
    }

    // 글 조회 (id)
    @GetMapping("/{id}")
    public BoardDto getBoard(@PathVariable int id) {
        return boardService.getBoardById(id);
    }

    // 글 전체 조회
    @GetMapping("/readall")
    public List<BoardDto> getBoard() {
        return boardService.readall();
    }

    // 제목 게시판을 위한 (id를 제외한 전체)조회
    @GetMapping()
    public List<DtoExceptContent> getBoardforList() {
        return boardService.ReadExceptContent();
    }

    // 글 수정
    @PutMapping("/{id}")
    public BoardDto updateBoard(@PathVariable int id, @RequestBody BoardDto boardDto) {
        return boardService.updateBoard(id, boardDto);
    }

    // 글 삭제
    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable int id) {
        boardService.deleteBoard(id);
    }
}
