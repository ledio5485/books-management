package com.booksmanagement.common.dataloader;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public interface Loader<T> {

    String getPathSource();

    Class<T> getClassType();

    void persistEntries(List<T> entries);
    default void execute() {
        List<T> entries = loadEntriesFromCsv();
        persistEntries(entries);
    }

    default List<T> loadEntriesFromCsv() {
        try (InputStream resource = new ClassPathResource(getPathSource()).getInputStream()) {
            return new CsvToBeanBuilder(new InputStreamReader(resource))
                    .withType(getClassType())
                    .withSeparator(';')
                    .withSkipLines(1)
                    .build()
                    .parse();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
