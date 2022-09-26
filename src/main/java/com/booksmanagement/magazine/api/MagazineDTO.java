package com.booksmanagement.magazine.api;

import com.booksmanagement.author.api.AuthorDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MagazineDTO {
    private String isbn;
    private List<AuthorDTO> authors;
    private String title;
    private LocalDate releaseDate;
}
