package com.booksmanagement.book.api;

import com.booksmanagement.author.api.AuthorDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {
    private String isbn;
    private List<AuthorDTO> authors;
    private String title;
    private String description;
}
