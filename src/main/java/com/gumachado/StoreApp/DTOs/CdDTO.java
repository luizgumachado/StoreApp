package com.gumachado.StoreApp.DTOs;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CdDTO extends ProductDTO{
    private String artist;
    private int yearOfRelease;
    private String genre;
}
