package com.gumachado.StoreApp.Controllers;

import com.gumachado.StoreApp.DTOs.BluRayDTO;
import com.gumachado.StoreApp.Services.BluRayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/BluRays")
@RequiredArgsConstructor
public class BluRayController {
    private final BluRayService blurayService;

    @GetMapping
    public ResponseEntity<List<BluRayDTO>> getAll() {
        List<BluRayDTO> bluRayDTOs = blurayService.findAll();

        if(bluRayDTOs.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(bluRayDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        try {
            BluRayDTO bluray = blurayService.findById(id);
            return ResponseEntity.ok(bluray);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BluRayDTO dto) {
        try {
            BluRayDTO created = blurayService.create(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar BluRay: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BluRayDTO dto) {
        try {
            BluRayDTO updated = blurayService.update(id, dto);
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
            blurayService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
