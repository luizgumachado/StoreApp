package com.gumachado.StoreApp.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book extends Product{
    private String author;
    private int pages;
    private int yearOfRelease;
    private String ISBN;
}
