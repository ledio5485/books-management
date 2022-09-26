package com.booksmanagement.magazine.service;

import com.booksmanagement.magazine.api.MagazineDTO;
import com.booksmanagement.magazine.persistence.MagazineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MagazineService {
    private final MagazineRepository magazineRepository;
    private final MagazineEntityToDTOConverter magazineConverter;

    public List<MagazineDTO> list(Sort sort) {
        return magazineRepository.findAll(sort).stream()
                .map(magazineConverter::convert)
                .collect(Collectors.toList());
    }

    public List<MagazineDTO> filterBy(String author) {
        return magazineRepository.findMagazineEntitiesByAuthorsEmail(author).stream()
                .map(magazineConverter::convert)
                .collect(Collectors.toList());
    }

    public Optional<MagazineDTO> getByIsbn(String isbn) {
        return magazineRepository.findById(isbn)
                .map(magazineConverter::convert);
    }
}
