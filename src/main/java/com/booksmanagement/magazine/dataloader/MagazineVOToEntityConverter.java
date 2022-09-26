package com.booksmanagement.magazine.dataloader;

import com.booksmanagement.author.persistence.AuthorEntity;
import com.booksmanagement.author.persistence.AuthorRepository;
import com.booksmanagement.magazine.persistence.MagazineEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MagazineVOToEntityConverter implements Converter<MagazineVO, MagazineEntity> {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final AuthorRepository authorRepository;

    @Override
    public MagazineEntity convert(MagazineVO entry) {
            MagazineEntity magazine = new MagazineEntity();
            magazine.setIsbn(entry.getIsbn());
            magazine.setTitle(entry.getTitle());
            magazine.setReleaseDate(LocalDate.parse(entry.getReleaseDate(), DATE_FORMATTER));
            magazine.setAuthors(getAuthors(entry.getAuthors()));
            return magazine;
        }

        private List<AuthorEntity> getAuthors(String authors) {
            return authorRepository.findAllById(List.of(authors.split(",")));
        }
}
