package com.booksmanagement.magazine.persistence;

import com.booksmanagement.author.persistence.AuthorEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "MAGAZINE")
@Data
public class MagazineEntity {
    @Id
    private String isbn;
    @ManyToMany
    private List<AuthorEntity> authors;
    private String title;
    private LocalDate releaseDate;
}
