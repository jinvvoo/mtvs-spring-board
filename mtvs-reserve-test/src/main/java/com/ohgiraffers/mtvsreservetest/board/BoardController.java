package com.ohgiraffers.mtvsreservetest.board;

import com.ohgiraffers.mtvsreservetest.domain.dto.BoardDTO;
import com.ohgiraffers.mtvsreservetest.domain.entity.Board;
import com.ohgiraffers.mtvsreservetest.domain.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class BoardController {
    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board")
    public String list(Model model) {
        List<BoardDTO> boardDTOList = boardService.getBoardList();
        model.addAttribute("postList", boardDTOList);
        return "board/list.html";
    }

    @GetMapping("/post")
    public String post() {
        return "board/post.html";
    }

    @PostMapping("/post")
    public String write(BoardDTO boardDTO) {
        boardService.savePost(boardDTO);
        return "redirect:/";
    }

    // 여기서부터 5단계
    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no") Long id, Model model) {
        BoardDTO boardDTO = boardService.getPost(id);

        model.addAttribute("boardDTO", boardDTO);

        return "board/detail.html";
    }
}


//    public BoardDTO getPost(Long id){
//        Optional<Board> boardWrapper = boardrepository.findById(id);
//        Board board = boardWrapper.get();
//
//        BoardDTO boardDTO = BoardDTO.builder()
//                .id(board.getId())
//                .author(board.getAuthor())
//                .title(board.getTitle())
//                .content(board.getContent())
//                .createdDate(board.getCreatedDate())
//                .build();
//
//        return boardDTO;