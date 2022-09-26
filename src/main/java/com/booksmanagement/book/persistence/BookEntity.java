package com.booksmanagement.book.persistence;

import com.booksmanagement.author.persistence.AuthorEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BOOK")
@Data
public class BookEntity {
    @Id
    private String isbn;
    @ManyToMany
    private List<AuthorEntity> authors;
    private String title;
    @Column(length = 1024)
    private String description;
}
