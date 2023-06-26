package com.ohgiraffers.mtvsreservetest.board;

import com.ohgiraffers.mtvsreservetest.domain.dto.BoardDTO;
import com.ohgiraffers.mtvsreservetest.domain.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

}
