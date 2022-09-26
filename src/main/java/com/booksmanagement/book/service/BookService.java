package com.booksmanagement.book.service;

import com.booksmanagement.book.api.BookDTO;
import com.booksmanagement.book.persistence.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookEntityToDTOConverter bookConverter;

    public List<BookDTO> list(Sort sort) {
        return bookRepository.findAll(sort).stream()
                .map(bookConverter::convert)
                .collect(Collectors.toList());
    }

    public List<BookDTO> filterBy(String author) {
        return bookRepository.findBookEntitiesByAuthorsEmail(author).stream()
                .map(bookConverter::convert)
                .collect(Collectors.toList());
    }

    public Optional<BookDTO> getByIsbn(String isbn) {
        return bookRepository.findById(isbn)
                .map(bookConverter::convert);
    }
}
