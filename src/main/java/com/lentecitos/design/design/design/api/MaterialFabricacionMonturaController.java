package com.lentecitos.design.design.design.api;

import com.lentecitos.design.design.design.domain.model.entities.MaterialFabricacionMontura;
import com.lentecitos.design.design.design.domain.service.MaterialFabricacionMonturaService;
import com.lentecitos.design.design.design.mapping.MaterialFabricacionMonturaMapper;
import com.lentecitos.design.design.design.resource.MaterialFabricacionMonturaResource;
import com.lentecitos.design.design.shared.exception.InternalServerErrorException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/material_fabricacion_montura")
public class MaterialFabricacionMonturaController {
    private final MaterialFabricacionMonturaService materialFabricacionMonturaService;
    private final MaterialFabricacionMonturaMapper materialFabricacionMonturaMapper;

    @PostMapping
    public ResponseEntity<MaterialFabricacionMonturaResource> save(@RequestBody MaterialFabricacionMontura materialFabricacionMontura){
        return new ResponseEntity<>(
                materialFabricacionMonturaMapper.toResource(materialFabricacionMonturaService.save(materialFabricacionMontura)),
                org.springframework.http.HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialFabricacionMontura>  fetchById(@PathVariable("id") Long id){
        return new ResponseEntity<>(
                materialFabricacionMonturaService.findById(id),
                org.springframework.http.HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public MaterialFabricacionMontura update(@RequestBody MaterialFabricacionMontura materialFabricacionMontura, @PathVariable("id") Long id){
        return materialFabricacionMonturaService.update(materialFabricacionMontura);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        if(materialFabricacionMonturaService.deleteById(id))
            return ResponseEntity.ok().build();

        throw new InternalServerErrorException("MaterialFabricacionMontura", "id", String.valueOf(id), "deleted");
    }

    @GetMapping
    public ResponseEntity<?> fetchAll(){
        return new ResponseEntity<>(
                materialFabricacionMonturaService.findAll(),
                org.springframework.http.HttpStatus.OK
        );
    }

}
