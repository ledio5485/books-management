package com.booksmanagement.book.service;

import com.booksmanagement.author.api.AuthorDTO;
import com.booksmanagement.author.persistence.AuthorEntity;
import com.booksmanagement.author.service.AuthorEntityToDTOConverter;
import com.booksmanagement.book.api.BookDTO;
import com.booksmanagement.book.persistence.BookEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookEntityToDTOConverter implements Converter<BookEntity, BookDTO> {
    private final AuthorEntityToDTOConverter authorConverter;

    @Override
    public BookDTO convert(BookEntity book) {
        return BookDTO.builder()
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .description(book.getDescription())
                .authors(convertAuthors(book.getAuthors()))
                .build();
    }

    private List<AuthorDTO> convertAuthors(List<AuthorEntity> authors) {
        return authors.stream()
                .map(authorConverter::convert)
                .collect(Collectors.toList());
    }
}
