package com.gumachado.StoreApp.Services;

import com.gumachado.StoreApp.DTOs.CdDTO;
import com.gumachado.StoreApp.Mappers.ProductMapper;
import com.gumachado.StoreApp.Models.Cd;
import com.gumachado.StoreApp.Repositories.CdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CdService {
    CdRepository cdRepository;
    ProductMapper productMapper;

    public List<CdDTO> findAll() {
        return cdRepository.findAll().stream().map(productMapper::toCdDto).toList();
    }

    public CdDTO findById(long id) {
        Cd cd = cdRepository.findById(id).orElseThrow(() -> new RuntimeException("CD com ID " + id + " não encontrado no sistema."));

        return productMapper.toCdDto(cd);
    }

    public CdDTO create(CdDTO dto) {
        Cd newCd = productMapper.toCdEntity(dto);
        Cd savedCd = cdRepository.save(newCd);

        return productMapper.toCdDto(savedCd);
    }

    public CdDTO update(Long id, CdDTO dto) {
        if (!cdRepository.existsById(id)) {
            throw new RuntimeException("Não foi possível encontrar: ID " + id + " inexistente.");
        }

        Cd cdEntity = productMapper.toCdEntity(dto);
        cdEntity.setId(id);
        Cd updatedCd = cdRepository.save(cdEntity);

        return productMapper.toCdDto(updatedCd);
    }

    public void delete(Long id) {
        if (!cdRepository.existsById(id)) {
            throw new RuntimeException("Não foi possível deletar: ID " + id + " inexistente.");
        }
        cdRepository.deleteById(id);
    }
}
