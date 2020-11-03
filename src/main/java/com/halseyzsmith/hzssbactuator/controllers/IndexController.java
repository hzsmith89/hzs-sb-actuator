package com.halseyzsmith.hzssbactuator.controllers;

import com.halseyzsmith.hzssbactuator.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final BookService bookService;

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getIndexPage(Model model) {
        model.addAttribute("books", bookService.getBooks());
        return "index";
    }
}
