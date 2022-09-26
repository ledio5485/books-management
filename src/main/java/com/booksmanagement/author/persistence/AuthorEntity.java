package com.booksmanagement.author.persistence;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHOR")
@Data
public class AuthorEntity {
    @Id
    private String email;
    private String name;
    private String surname;
}
