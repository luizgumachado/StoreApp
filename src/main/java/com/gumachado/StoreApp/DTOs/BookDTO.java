package com.gumachado.StoreApp.DTOs;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BookDTO extends ProductDTO {
    private String author;
    private int pages;
    private int yearOfRelease;
    private String ISBN;
}
