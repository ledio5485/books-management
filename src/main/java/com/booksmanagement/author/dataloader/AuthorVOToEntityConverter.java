package com.booksmanagement.author.dataloader;

import com.booksmanagement.author.persistence.AuthorEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AuthorVOToEntityConverter implements Converter<AuthorVO, AuthorEntity> {

    @Override
    public AuthorEntity convert(AuthorVO entry) {
        AuthorEntity author = new AuthorEntity();
        author.setEmail(entry.getEmail());
        author.setName(entry.getName());
        author.setSurname(entry.getSurname());
        return author;
    }
}
