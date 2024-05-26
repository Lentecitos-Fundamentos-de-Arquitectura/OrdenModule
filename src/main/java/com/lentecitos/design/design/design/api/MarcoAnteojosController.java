package com.lentecitos.design.design.design.api;

import com.lentecitos.design.design.design.domain.model.entities.MarcoAnteojos;
import com.lentecitos.design.design.design.domain.service.MarcoAnteojosService;
import com.lentecitos.design.design.design.mapping.MarcoAnteojosMapper;
import com.lentecitos.design.design.design.resource.MarcoAnteojosResource;
import com.lentecitos.design.design.shared.exception.InternalServerErrorException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/marco_anteojos")
public class MarcoAnteojosController {
private final MarcoAnteojosService marcoAnteojosService;
    private final MarcoAnteojosMapper marcoAnteojosMapper;

    @PostMapping
    public ResponseEntity<MarcoAnteojosResource> save(@RequestBody MarcoAnteojos marcoAnteojos){
        return new ResponseEntity<>(
                marcoAnteojosMapper.toResource(marcoAnteojosService.save(marcoAnteojos)),
                org.springframework.http.HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcoAnteojos>  fetchById(@PathVariable("id") Long id){
        return new ResponseEntity<>(
                marcoAnteojosService.findById(id),
                org.springframework.http.HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public MarcoAnteojos update(@RequestBody MarcoAnteojos marcoAnteojos, @PathVariable("id") Long id){
        return marcoAnteojosService.update(marcoAnteojos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        if(marcoAnteojosService.deleteById(id))
            return ResponseEntity.ok().build();

        throw new InternalServerErrorException("MarcoAnteojos", "id", String.valueOf(id), "deleted");
    }

    @GetMapping
    public ResponseEntity <?> fetchall(){
        return ResponseEntity.ok(marcoAnteojosService.findAll());
    }


}
