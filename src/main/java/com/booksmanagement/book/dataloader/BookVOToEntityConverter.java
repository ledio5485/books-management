package com.booksmanagement.book.dataloader;

import com.booksmanagement.author.persistence.AuthorEntity;
import com.booksmanagement.author.persistence.AuthorRepository;
import com.booksmanagement.book.persistence.BookEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookVOToEntityConverter implements Converter<BookVO, BookEntity> {
    private final AuthorRepository authorRepository;

    @Override
    public BookEntity convert(BookVO entry) {
            BookEntity book = new BookEntity();
            book.setIsbn(entry.getIsbn());
            book.setTitle(entry.getTitle());
            book.setDescription(entry.getDescription());
            book.setAuthors(getAuthors(entry.getAuthors()));
            return book;
        }

    private List<AuthorEntity> getAuthors(String authors) {
        return authorRepository.findAllById(List.of(authors.split(",")));
    }
}
