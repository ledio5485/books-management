package com.booksmanagement.book.api;

import com.booksmanagement.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookResource {
    private final BookService bookService;

    @GetMapping
    public List<BookDTO> list(
            @RequestParam(value = "sortBy", defaultValue = "title", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
    ) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        return bookService.list(sort);
    }

    @GetMapping("/filter")
    public List<BookDTO> list(@RequestParam(value = "author") String author) {
        return bookService.filterBy(author);
    }

    @GetMapping(value = "{isbn}")
    public ResponseEntity<BookDTO> getByIsbn(@PathVariable("isbn") @NotNull String isbn) {
        return ResponseEntity.of(bookService.getByIsbn(isbn));
    }
}
