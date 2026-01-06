package com.gumachado.StoreApp.DTOs;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BluRayDTO extends ProductDTO {
    private String director;
    private int yearOfRelease;
    private int durationMins;
    private String genre;
}
