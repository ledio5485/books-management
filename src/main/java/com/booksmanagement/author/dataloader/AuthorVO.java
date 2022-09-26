package com.booksmanagement.author.dataloader;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class AuthorVO {
    @CsvBindByPosition(position = 0)
    private String email;
    @CsvBindByPosition(position = 1)
    private String name;
    @CsvBindByPosition(position = 2)
    private String surname;
}