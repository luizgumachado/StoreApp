package com.gumachado.StoreApp.Services;

import com.gumachado.StoreApp.DTOs.ProductDTO;
import com.gumachado.StoreApp.Mappers.ProductMapper;
import com.gumachado.StoreApp.Models.Product;
import com.gumachado.StoreApp.Repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(productMapper::toDto).toList();
    }

    public ProductDTO findById(long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("O id fornecido não corresponde a nenhum produto."));

        return productMapper.toDto(product);
    }
}
