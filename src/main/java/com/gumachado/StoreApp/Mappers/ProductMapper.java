package com.gumachado.StoreApp.Mappers;

import com.gumachado.StoreApp.DTOs.BluRayDTO;
import com.gumachado.StoreApp.DTOs.BookDTO;
import com.gumachado.StoreApp.DTOs.CdDTO;
import com.gumachado.StoreApp.DTOs.ProductDTO;
import com.gumachado.StoreApp.Models.BluRay;
import com.gumachado.StoreApp.Models.Book;
import com.gumachado.StoreApp.Models.Cd;
import com.gumachado.StoreApp.Models.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public BookDTO toBookDTO(Book entity) {
        if(entity == null) return null;
        BookDTO dto = new BookDTO();
        mapCommonFieldsToDTO(dto, entity);
        dto.setAuthor(entity.getAuthor());
        dto.setPages(entity.getPages());
        dto.setYearOfRelease(entity.getYearOfRelease());
        dto.setISBN(entity.getISBN());

        return dto;
    }

    public CdDTO toCdDto(Cd entity) {
        if (entity == null) return null;
        CdDTO dto = new CdDTO();
        mapCommonFieldsToDTO(dto, entity);
        dto.setArtist(entity.getArtist());
        dto.setYearOfRelease(entity.getYearOfRelease());
        dto.setGenre(entity.getGenre());

        return dto;
    }

    public BluRayDTO toBluRayDTO(BluRay entity) {
        if (entity == null) return null;
        BluRayDTO dto = new BluRayDTO();
        mapCommonFieldsToDTO(dto, entity);
        dto.setDirector(entity.getDirector());
        dto.setYearOfRelease(entity.getYearOfRelease());
        dto.setDurationMins(entity.getDurationMins());
        dto.setGenre(entity.getGenre());

        return dto;
    }

    public Cd toCdEntity(CdDTO dto) {
        if (dto == null) return null;
        Cd entity = new Cd();
        mapCommonFieldsToEntity(dto, entity);
        entity.setArtist(dto.getArtist());
        entity.setYearOfRelease(dto.getYearOfRelease());
        entity.setGenre(dto.getGenre());

        return entity;
    }

    public BluRay toBluRayEntity(BluRayDTO dto) {
        if (dto == null) return null;
        BluRay entity = new BluRay();
        mapCommonFieldsToEntity(dto, entity);
        entity.setDirector(entity.getDirector());
        entity.setYearOfRelease(dto.getYearOfRelease());
        entity.setDurationMins(dto.getDurationMins());
        entity.setGenre(dto.getGenre());

        return entity;
    }

    public Book toBookEntity(BookDTO dto) {
        if (dto == null) return null;
        Book entity = new Book();
        mapCommonFieldsToEntity(dto, entity);
        entity.setAuthor(dto.getAuthor());
        entity.setPages(dto.getPages());
        entity.setYearOfRelease(dto.getYearOfRelease());
        entity.setISBN((dto.getISBN()));

        return entity;
    }

    public ProductDTO toDto(Product entity) {
        if (entity instanceof Book book) return toBookDTO(book);
        if (entity instanceof Cd cd) return toCdDto(cd);
        if (entity instanceof BluRay bluray) return toBluRayDTO(bluray);
        return null;
    }

    public Product toEntity(ProductDTO dto) {
        if (dto instanceof BookDTO bookDto) return toBookEntity(bookDto);
        if (dto instanceof CdDTO cdDto) return toCdEntity(cdDto);
        if (dto instanceof BluRayDTO blurayDto) return toBluRayEntity(blurayDto);
        return null;
    }

    private void mapCommonFieldsToEntity(ProductDTO dto, Product entity) {
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setQuantityInStock(dto.getQuantityInStock());
    }

    private void mapCommonFieldsToDTO(ProductDTO dto, Product entity) {
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setQuantityInStock(entity.getQuantityInStock());
    }
}
