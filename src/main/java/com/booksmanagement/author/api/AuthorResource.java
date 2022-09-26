package com.booksmanagement.author.api;

import com.booksmanagement.author.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorResource {
    private final AuthorService authorService;

    @GetMapping
    public List<AuthorDTO> list() {
        return authorService.list();
    }
}
