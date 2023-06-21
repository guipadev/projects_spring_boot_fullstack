package com.project.coches.controller;

import com.project.coches.domain.dto.BrandCarDto;
import com.project.coches.domain.service.IBrandCarService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador rest de Marca Coche
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/marcas-coches")
public class BrandCarController {

    /**
     * Servicio de marca coche
     */
    private  final IBrandCarService iBrandCarService;

    @GetMapping
    public ResponseEntity<List<BrandCarDto>> getAll() {
        return ResponseEntity.ok(iBrandCarService.getAll());
        // ALTERNATIVA 2 return ResponseEntity.status(HttpStatus.OK).body(iBrandCarService.getAll());
        // ALTERNATIVA 3 return new ResponseEntity<>(iBrandCarService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BrandCarDto> getBrandCar(@PathVariable Integer id) {
        return ResponseEntity.of(iBrandCarService.getBrandCar(id));
    }

    @PostMapping
    public ResponseEntity<BrandCarDto> save(@RequestBody BrandCarDto brandCarDtoNew) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iBrandCarService.save(brandCarDtoNew));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
