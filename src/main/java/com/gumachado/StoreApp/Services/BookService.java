package com.gumachado.StoreApp.Services;

import com.gumachado.StoreApp.DTOs.BookDTO;
import com.gumachado.StoreApp.Mappers.ProductMapper;
import com.gumachado.StoreApp.Models.Book;
import com.gumachado.StoreApp.Repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    BookRepository bookRepository;
    ProductMapper productMapper;

    public List<BookDTO> findAll() {
        return bookRepository.findAll().stream().map(productMapper::toBookDTO).toList();
    }

    public BookDTO findById(long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro com ID " + id + " não encontrado no sistema."));

        return productMapper.toBookDTO(book);
    }

    public BookDTO create(BookDTO dto) {
        Book newBook = productMapper.toBookEntity(dto);
        Book savedBook = bookRepository.save(newBook);

        return productMapper.toBookDTO(savedBook);
    }

    public BookDTO update(Long id, BookDTO dto) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Não foi possível encontrar: ID " + id + " inexistente.");
        }

        Book bookEntity = productMapper.toBookEntity(dto);
        bookEntity.setId(id);
        Book updatedBook = bookRepository.save(bookEntity);

        return productMapper.toBookDTO(updatedBook);
    }

    public void delete(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Não foi possível deletar: ID " + id + " inexistente.");
        }
        bookRepository.deleteById(id);
    }
}
