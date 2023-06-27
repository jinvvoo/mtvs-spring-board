package com.ohgiraffers.mtvsreserve;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    @RequestMapping(value = {"/"})
    public String main(){

        return "main";
    }
}
