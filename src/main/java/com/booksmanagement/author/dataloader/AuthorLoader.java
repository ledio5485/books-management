package com.booksmanagement.author.dataloader;

import com.booksmanagement.author.persistence.AuthorEntity;
import com.booksmanagement.author.persistence.AuthorRepository;
import com.booksmanagement.common.dataloader.Loader;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthorLoader implements Loader<AuthorVO> {
    private final AuthorRepository authorRepository;
    private final AuthorVOToEntityConverter authorConverter;

    @Value( "${application.path.authors}" )
    private String pathAuthors;
    @Override
    public String getPathSource() {
        return pathAuthors;
    }

    @Override
    public Class<AuthorVO> getClassType() {
        return AuthorVO.class;
    }

    @Override
    public void persistEntries(List<AuthorVO> entries) {
        List<AuthorEntity> authors = entries.stream()
                .map(authorConverter::convert)
                .collect(Collectors.toList());

        authorRepository.saveAll(authors);
    }
}
