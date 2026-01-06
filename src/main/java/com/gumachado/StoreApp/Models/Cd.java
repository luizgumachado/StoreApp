package com.gumachado.StoreApp.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cd extends Product{
    private String artist;
    private int yearOfRelease;
    private String genre;
}
