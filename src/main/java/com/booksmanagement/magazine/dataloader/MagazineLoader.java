package com.booksmanagement.magazine.dataloader;

import com.booksmanagement.common.dataloader.Loader;
import com.booksmanagement.magazine.persistence.MagazineEntity;
import com.booksmanagement.magazine.persistence.MagazineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MagazineLoader implements Loader<MagazineVO> {
    private final MagazineRepository magazineRepository;
    private final MagazineVOToEntityConverter magazineConverter;

    @Value("${application.path.magazines}")
    private String pathMagazines;

    @Override
    public String getPathSource() {
        return pathMagazines;
    }

    @Override
    public Class<MagazineVO> getClassType() {
        return MagazineVO.class;
    }

    @Override
    public void persistEntries(List<MagazineVO> entries) {
        List<MagazineEntity> books = entries.stream()
                .map(magazineConverter::convert)
                .collect(Collectors.toList());
        magazineRepository.saveAll(books);
    }
}
