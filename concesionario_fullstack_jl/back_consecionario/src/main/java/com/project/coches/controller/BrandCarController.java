package com.project.coches.controller;

import com.project.coches.domain.dto.BrandCarDto;
import com.project.coches.domain.service.IBrandCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador rest de Marca Coche
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/brands-car")
public class BrandCarController {

    /**
     * Servicio de marca coche
     */
    private  final IBrandCarService iBrandCarService;

    /**
     * Devuelve lista de marcas coche
     * @return HttpCode OK con lista de marcas coche
     */
    @GetMapping
    public ResponseEntity<List<BrandCarDto>> getAll() {
        return ResponseEntity.ok(iBrandCarService.getAll());
        // ALTERNATIVA 2 return ResponseEntity.status(HttpStatus.OK).body(iBrandCarService.getAll());
        // ALTERNATIVA 3 return new ResponseEntity<>(iBrandCarService.getAll(), HttpStatus.OK);
    }

    /**
     * Devuelve una marca coche dado su id
     * @param id de la marca coche a buscar
     * @return HttpCode OK si la encuentra, HttpCode Not Found de lo contrario
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<BrandCarDto> getBrandCar(@PathVariable Integer id) {
        return ResponseEntity.of(iBrandCarService.getBrandCar(id));
    }

    /**
     * Crea una nueva marca coche
     * @param brandCarDtoNew marca coche a crear
     * @return HttpCOde Created si la guarda correctamente, HttpCode BadRequest de lo contrario
     */
    @PostMapping
    public ResponseEntity<BrandCarDto> save(@RequestBody BrandCarDto brandCarDtoNew) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iBrandCarService.save(brandCarDtoNew));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    /**
     * Actualiza una marca coche
     * @param brandCarDtoUpdate Marca coche actualizada
     * @return HttpCode OK si la actualiza correctamente
     */
    @PatchMapping
    public ResponseEntity<BrandCarDto> update(@RequestBody BrandCarDto brandCarDtoUpdate) {
        return ResponseEntity.of(iBrandCarService.update(brandCarDtoUpdate));
    }

    /**
     * ELimina una marca coche dado su id
     * @param id de la marca coche a eliminar
     * @return HttpCode OK si elimina, HttpCode Not Found si no existe
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(this.iBrandCarService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
