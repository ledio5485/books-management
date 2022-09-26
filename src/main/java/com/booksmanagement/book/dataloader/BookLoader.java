package com.booksmanagement.book.dataloader;

import com.booksmanagement.book.persistence.BookRepository;
import com.booksmanagement.common.dataloader.Loader;
import com.booksmanagement.book.persistence.BookEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookLoader implements Loader<BookVO> {
    private final BookRepository bookRepository;
    private final BookVOToEntityConverter bookConverter;

    @Value( "${application.path.books}" )
    private String pathBooks;
    @Override
    public String getPathSource() {
        return pathBooks;
    }

    @Override
    public Class<BookVO> getClassType() {
        return BookVO.class;
    }

    @Override
    public void persistEntries(List<BookVO> entries) {
        List<BookEntity> books = entries.stream()
                .map(bookConverter::convert)
                .collect(Collectors.toList());
        bookRepository.saveAll(books);
    }
}
