package com.lentecitos.design.design.design.api;

import com.lentecitos.design.design.design.domain.model.entities.MaterialFabricaLuna;
import com.lentecitos.design.design.design.domain.service.MaterialFabricaLunaService;
import com.lentecitos.design.design.design.mapping.MaterialFabricaLunaMapper;
import com.lentecitos.design.design.design.resource.MaterialFabricaLunaResource;
import com.lentecitos.design.design.shared.exception.InternalServerErrorException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/material_fabrica_luna")
public class MaterialFabricaLunaController {
    private final MaterialFabricaLunaService materialFabricaLunaService;
    private final MaterialFabricaLunaMapper materialFabricaLunaMapper;

    @PostMapping
    public ResponseEntity<MaterialFabricaLunaResource> save(@RequestBody MaterialFabricaLuna materialFabricaLuna){
        return new ResponseEntity<>(
                materialFabricaLunaMapper.toResource(materialFabricaLunaService.save(materialFabricaLuna)),
                org.springframework.http.HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialFabricaLuna>  fetchById(@PathVariable("id") Long id){
        return new ResponseEntity<>(
                materialFabricaLunaService.findById(id),
                org.springframework.http.HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public MaterialFabricaLuna update(@RequestBody MaterialFabricaLuna materialFabricaLuna, @PathVariable("id") Long id){
        return materialFabricaLunaService.update(materialFabricaLuna);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        if(materialFabricaLunaService.deleteById(id))
            return ResponseEntity.ok().build();

        throw new InternalServerErrorException("MaterialFabricaLuna", "id", String.valueOf(id), "deleted");
    }

    @GetMapping
    public ResponseEntity<?> fetchAll(){
        return new ResponseEntity<>(
                materialFabricaLunaService.findAll(),
                org.springframework.http.HttpStatus.OK
        );
    }
}
