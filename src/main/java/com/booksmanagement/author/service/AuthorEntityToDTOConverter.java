package com.booksmanagement.author.service;

import com.booksmanagement.author.api.AuthorDTO;
import com.booksmanagement.author.persistence.AuthorEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AuthorEntityToDTOConverter implements Converter<AuthorEntity, AuthorDTO> {
    @Override
    public AuthorDTO convert(AuthorEntity source) {
        return AuthorDTO.builder()
                .email(source.getEmail())
                .name(source.getName())
                .surname(source.getSurname())
                .build();
    }
}
