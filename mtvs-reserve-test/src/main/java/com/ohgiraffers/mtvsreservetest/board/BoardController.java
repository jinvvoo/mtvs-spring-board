package com.ohgiraffers.mtvsreservetest.board;

import com.ohgiraffers.mtvsreservetest.board.dto.BoardDTO;
import com.ohgiraffers.mtvsreservetest.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "redirect:/board";
    }

    // detail 조회
    @GetMapping("/post/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        BoardDTO boardDTO = boardService.getPost(id);

        model.addAttribute("post", boardDTO);

        return "board/detail.html";
    }

    //edit 추가
    @GetMapping("/post/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        BoardDTO boardDTO = boardService.getPost(id);
        model.addAttribute("post", boardDTO);
        return "board/edit.html";
    }

    @PutMapping("/post/edit/{id}")
    public String update(BoardDTO boardDTO) {
        boardService.savePost(boardDTO);
        return "redirect:/board";
    }

    @DeleteMapping("/post/{id}")
    public String delete(@PathVariable("id") Long id) {
        boardService.deletePost(id);
        return "redirect:/board";
    }

}
