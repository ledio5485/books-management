package com.booksmanagement.common.dataloader;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader {
    private final List<Loader<?>> loaders;

    @PostConstruct
    void loadCsvFiles() {
        loaders.forEach(Loader::execute);
    }
}
