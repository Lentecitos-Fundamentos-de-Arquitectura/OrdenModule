package com.lentecitos.design.design.design.api;

import com.lentecitos.design.design.design.domain.model.entities.DisenoAnteojos;
import com.lentecitos.design.design.design.domain.service.DisenoAnteojosService;
import com.lentecitos.design.design.design.mapping.DisenoAnteojosMapper;
import com.lentecitos.design.design.design.resource.DisenoAnteojosResource;
import com.lentecitos.design.design.shared.exception.InternalServerErrorException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("diseno_anteojos")
public class DisenoAnteojosController {

    private final DisenoAnteojosService disenoAnteojosService;
    private final DisenoAnteojosMapper disenoAnteojosMapper;

    @PostMapping
    public ResponseEntity<DisenoAnteojosResource> save(@RequestBody DisenoAnteojos disenoAnteojos){
        return new ResponseEntity<>(
                disenoAnteojosMapper.toResource(disenoAnteojosService.save(disenoAnteojos)),
                org.springframework.http.HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisenoAnteojos>  fetchById(@PathVariable("id") Long id){
        return new ResponseEntity<>(
                disenoAnteojosService.findById(id),
                org.springframework.http.HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public DisenoAnteojos update(@RequestBody DisenoAnteojos disenoAnteojos, @PathVariable("id") Long id){
        return disenoAnteojosService.update(disenoAnteojos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        if(disenoAnteojosService.deleteById(id))
            return ResponseEntity.ok().build();

        throw new InternalServerErrorException("DisenoAnteojos", "id", String.valueOf(id), "deleted");
    }

    @GetMapping
    public ResponseEntity<?> fetchAll(){
        return ResponseEntity.ok(disenoAnteojosService.findAll());
    }



}
