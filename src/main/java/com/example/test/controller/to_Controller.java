package com.example.test.controller;

import com.example.test.dto.BoardDto;
import com.example.test.dto.DtoForList;
import com.example.test.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class to_Controller {

    @Autowired
    private BoardService boardService;

    // 0.0 테스트용 전체 조회 (R)
    @GetMapping("/readall")
    public List<BoardDto> getBoard() {
        return boardService.readall();
    }

    // 1.1 게시글 작성 (C)
    @PostMapping()
    public void createBoard(@RequestBody BoardDto boardDto) {
        boardService.saveBoard(boardDto);
    }

    // 1.2 게시글 조회 (R)
    @GetMapping("/{id}")
    public BoardDto getBoard(@PathVariable int id) {
        return boardService.getBoardById(id);
    }

    // 1.3 게시글 수정 (U)
    @PutMapping("/{id}")
    public BoardDto updateBoard(@PathVariable int id, @RequestBody BoardDto boardDto) {
        return boardService.updateBoard(id, boardDto);
    }

    // 1.4 게시글 삭제 (D)
    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable int id) {
        boardService.deleteBoard(id);
    }

    // 1.5 게시글 공감 (U)
    @PutMapping("/{id}/like")
    public void likeBoard(@PathVariable int id) {
        boardService.likeBoard(id);
    }

    // 2.1 게시글 리스트 전체 조회 (R)
    @GetMapping()
    public List<DtoForList> getBoardforList() {
        return boardService.ReadExceptContent();
    }

    // 2.2 게시글 검색(해서 맞는 것 조회) (R)
    // 모든 게시글 들고와서 내가 검색한 내용이 title에 있는지 확인
    @GetMapping("/search")
    public List<DtoForList> SearchForList(@RequestParam String title) {
        return boardService.ReadForSearch(title);
    }

    // 2.3 게시글 고정(U)
    @PutMapping("/{id}/pin")
    public void pinBoard(@PathVariable int id) {
        boardService.pinBoard(id);
    }

}
