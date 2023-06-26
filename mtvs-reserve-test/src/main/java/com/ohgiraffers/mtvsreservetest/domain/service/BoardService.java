package com.ohgiraffers.mtvsreservetest.domain.service;


import com.ohgiraffers.mtvsreservetest.domain.repository.BoardRepository;
import com.ohgiraffers.mtvsreservetest.domain.dto.BoardDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BoardService {
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Long savePost(BoardDTO boardDTO) {
        return boardRepository.save(boardDTO.toEntity()).getId();
    }
}