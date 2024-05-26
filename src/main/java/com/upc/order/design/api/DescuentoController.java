package com.upc.order.design.api;

import com.upc.order.design.domain.model.Descuento;
import com.upc.order.design.domain.service.DescuentoService;
import com.upc.order.design.mapping.DescuentoMapper;
import com.upc.order.design.resource.CreateDescuentoResource;
import com.upc.order.design.resource.DescuentoResource;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/descuento")
public class DescuentoController {
    private final DescuentoService descuentoService;
    private final DescuentoMapper descuentoMapper;

    @PostMapping
    public ResponseEntity<DescuentoResource> createDescuento(@RequestBody CreateDescuentoResource createDescuentoResource){
        Descuento descuento = descuentoService.save(descuentoMapper.toEntity(createDescuentoResource));
        return ResponseEntity.status(HttpStatus.CREATED).body(descuentoMapper.toResource(descuento));
    }

    @GetMapping
    public ResponseEntity<List<DescuentoResource>> getAllDescuentos(){
        List<Descuento> descuentos = descuentoService.findAll();
        return ResponseEntity.ok(descuentos.stream().map(descuentoMapper::toResource).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DescuentoResource> getDescuentoById(@PathVariable Integer id){
        Descuento descuento = descuentoService.findById(Long.valueOf(id));
        return ResponseEntity.ok(descuentoMapper.toResource(descuento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DescuentoResource> updateDescuento(@PathVariable Integer id, @RequestBody CreateDescuentoResource createDescuentoResource){
        Descuento descuento = descuentoService.update(descuentoMapper.toEntity(createDescuentoResource));
        return ResponseEntity.ok(descuentoMapper.toResource(descuento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDescuento(@PathVariable Integer id){
        descuentoService.deleteById(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }

}
