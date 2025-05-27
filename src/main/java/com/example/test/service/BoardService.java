package com.example.test.service;

import com.example.test.dto.BoardDto;
import com.example.test.dto.DtoForList;
import com.example.test.dto.DtoForReply;
import com.example.test.entity.BoardEntity;
import com.example.test.entity.Reply;
import com.example.test.repository.BoardRepository;
import com.example.test.repository.ReplyRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

@Service
@Transactional
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    // 글 저장
    public void saveBoard(BoardDto dto) {
        BoardEntity entity = convertToEntity(dto);
        boardRepository.save(entity);
    }

    // 글 단건 조회
    public BoardDto getBoardById(int id) {
        BoardEntity entity = boardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 게시글이 없습니다. id=" + id));
        return convertToDto(entity);
    }

    // 원래 ArrayList는 일반적인 리스트 형식이며, 구조체나 클래스 객체를 리스트 요소로 저장할 수도 있다.
    // "List<엔티티>" 이건 자료형을 정의한 것이라고 봐도 됨
    public List<BoardDto> readall() {
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtos = new ArrayList<>();

        for (BoardEntity boardEntity : boardEntities) {
            BoardDto dto = convertToDto(boardEntity);
            boardDtos.add(dto);
        }
        return boardDtos;
    }

    public List<DtoForList> ReadExceptContent() {
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<DtoForList> DEC = new ArrayList<>();

        for (BoardEntity boardEntity : boardEntities) {
            DtoForList dto = new DtoForList(boardEntity.getId(), boardEntity.getTitle(), boardEntity.getPin());
            DEC.add(dto);
        }
        return DEC;
    }

    public List<DtoForList> ReadForSearch(String name) {
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<DtoForList> DEC = new ArrayList<>();

        for (BoardEntity boardEntity : boardEntities) {
            if (boardEntity.getTitle().contains(name)) {
                DtoForList dto = new DtoForList(boardEntity.getId(), boardEntity.getTitle(), boardEntity.getPin());
                DEC.add(dto);
            }
        }
        return DEC;
    }

    // 글 수정
    public BoardDto updateBoard(int id, BoardDto dto) {
        BoardEntity entity = boardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 게시글이 없습니다. id=" + id));
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        return convertToDto(boardRepository.save(entity));
    }

    // 글 삭제
    public void deleteBoard(int id) {
        boardRepository.deleteById(id);
    }

    // 공감 기능
    public void likeBoard(int id) {
        BoardEntity entity = boardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 게시글이 없습니다. id=" + id));
        entity.setGood(entity.getGood() + 1);
    }

    // 고정글 기능
    public void pinBoard(int id) {
        BoardEntity entity = boardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 게시글이 없습니다. id=" + id));
        entity.setPin(1 - entity.getPin());
    }


    // 엔티티의 get메서드를 활용해 dto에 부여하는데, 모든 컬럼에 대해 한 번에 실행하도록 함수화
    private BoardDto convertToDto(BoardEntity entity) {
        BoardDto dto = new BoardDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setPin(entity.getPin());
        dto.setPin(entity.getPin());
        dto.setGood(entity.getGood());
        return dto;
    }

    // 위와 마찬가지
    private BoardEntity convertToEntity(BoardDto dto) {
        return new BoardEntity(dto.getTitle(), dto.getContent(), dto.getCreatedAt(), dto.getPin(), dto.getGood());
    }
}