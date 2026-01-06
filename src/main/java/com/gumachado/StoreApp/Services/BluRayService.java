package com.gumachado.StoreApp.Services;

import com.gumachado.StoreApp.DTOs.BluRayDTO;
import com.gumachado.StoreApp.Mappers.ProductMapper;
import com.gumachado.StoreApp.Models.BluRay;
import com.gumachado.StoreApp.Repositories.BluRayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BluRayService {
    private final BluRayRepository blurayRepository;
    private final ProductMapper productMapper;

    public List<BluRayDTO> findAll() {
        return blurayRepository.findAll().stream().map(productMapper::toBluRayDTO).toList();
    }

    public BluRayDTO findById(long id) {
        BluRay bluray = blurayRepository.findById(id).orElseThrow(() -> new RuntimeException("O id não corresponde a nenhum Bluray!"));

        return productMapper.toBluRayDTO((bluray));
    }

    public BluRayDTO create(BluRayDTO dto) {
        BluRay newBluray = productMapper.toBluRayEntity(dto);
        BluRay savedBluray = blurayRepository.save(newBluray);

        return productMapper.toBluRayDTO(savedBluray);
    }

    public BluRayDTO update(Long id, BluRayDTO dto) {
        if (!blurayRepository.existsById(id)) {
            throw new RuntimeException("Não foi possível encontrar: ID " + id + " inexistente.");
        }

        BluRay blurayEntity = productMapper.toBluRayEntity(dto);
        blurayEntity.setId(id);
        BluRay updatedBluray = blurayRepository.save(blurayEntity);

        return productMapper.toBluRayDTO(updatedBluray);
    }

    public void delete(Long id) {
        if (!blurayRepository.existsById(id)) {
            throw new RuntimeException("Não foi possível deletar: ID " + id + " inexistente.");
        }
        blurayRepository.deleteById(id);
    }
}
