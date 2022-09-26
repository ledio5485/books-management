package com.booksmanagement.magazine.service;

import com.booksmanagement.author.api.AuthorDTO;
import com.booksmanagement.author.persistence.AuthorEntity;
import com.booksmanagement.author.service.AuthorEntityToDTOConverter;
import com.booksmanagement.magazine.api.MagazineDTO;
import com.booksmanagement.magazine.persistence.MagazineEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MagazineEntityToDTOConverter implements Converter<MagazineEntity, MagazineDTO> {
    private final AuthorEntityToDTOConverter authorConverter;

    @Override
    public MagazineDTO convert(MagazineEntity magazine) {
        return MagazineDTO.builder()
                .isbn(magazine.getIsbn())
                .authors(convertAuthors(magazine.getAuthors()))
                .title(magazine.getTitle())
                .releaseDate(magazine.getReleaseDate())
                .build();
    }

    private List<AuthorDTO> convertAuthors(List<AuthorEntity> authors) {
        return authors.stream()
                .map(authorConverter::convert)
                .collect(Collectors.toList());
    }
}
