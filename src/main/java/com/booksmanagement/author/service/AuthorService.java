package com.booksmanagement.author.service;

import com.booksmanagement.author.api.AuthorDTO;
import com.booksmanagement.author.persistence.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorEntityToDTOConverter authorConverter;

    public List<AuthorDTO> list() {
        return authorRepository.findAll().stream()
                .map(authorConverter::convert)
                .collect(Collectors.toList());
    }
}
