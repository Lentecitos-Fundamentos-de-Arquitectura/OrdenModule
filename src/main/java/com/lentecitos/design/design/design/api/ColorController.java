package com.lentecitos.design.design.design.api;

import com.lentecitos.design.design.design.domain.model.entities.Color;
import com.lentecitos.design.design.design.domain.service.ColorService;
import com.lentecitos.design.design.design.mapping.ColorMapper;
import com.lentecitos.design.design.design.resource.ColorResource;
import com.lentecitos.design.design.shared.exception.InternalServerErrorException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("colors")
public class ColorController {

    private final ColorService colorService;
    private final ColorMapper colorMapper;

    @PostMapping
    public ResponseEntity<ColorResource> save(@RequestBody Color color){
        return new ResponseEntity<>(
                colorMapper.toResource(colorService.save(color)),
                org.springframework.http.HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Color>  fetchById(@PathVariable("id") Long id){
        return new ResponseEntity<>(
                colorService.findById(id),
                org.springframework.http.HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public Color update(@RequestBody Color color, @PathVariable("id") Long id){
        return colorService.update(color);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        if(colorService.deleteById(id))
            return ResponseEntity.ok().build();

        throw new InternalServerErrorException("Color", "id", String.valueOf(id), "deleted");
    }

    @GetMapping
    public ResponseEntity<List<Color>>  fetchAll(){
        return ResponseEntity.ok(colorService.findAll());
    }

}
