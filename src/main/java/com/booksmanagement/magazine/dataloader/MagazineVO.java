package com.booksmanagement.magazine.dataloader;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class MagazineVO {
    @CsvBindByPosition(position = 0)
    private String title;
    @CsvBindByPosition(position = 1)
    private String isbn;
    @CsvBindByPosition(position = 2)
    private String authors;
    @CsvBindByPosition(position = 3)
    private String releaseDate;
}
