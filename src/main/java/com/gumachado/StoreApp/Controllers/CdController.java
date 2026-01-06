package com.gumachado.StoreApp.Controllers;

import com.gumachado.StoreApp.DTOs.CdDTO;
import com.gumachado.StoreApp.Services.CdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/CDs")
@RequiredArgsConstructor
public class CdController {
    private final CdService cdService;

    @GetMapping
    public ResponseEntity<List<CdDTO>> getAll() {
        List<CdDTO> cdDTOs = cdService.findAll();

        if(cdDTOs.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(cdDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            CdDTO cd = cdService.findById(id);
            return ResponseEntity.ok(cd);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CdDTO dto) {
        try {
            CdDTO created = cdService.create(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar CD: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CdDTO dto) {
        try {
            CdDTO updated = cdService.update(id, dto);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Algo deu errado, tente novamente mais tarde.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            cdService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}