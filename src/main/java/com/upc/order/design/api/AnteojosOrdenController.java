package com.upc.order.design.api;

import com.upc.order.design.domain.model.AnteojosOrden;
import com.upc.order.design.domain.service.AnteojosOrdenService;
import com.upc.order.design.mapping.AnteojosOrdenMapper;
import com.upc.order.design.resource.AnteojosOrdenResource;
import com.upc.order.design.resource.CreateAnteojosOrdenResource;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/anteojos-orden")
public class AnteojosOrdenController {

    private final AnteojosOrdenService anteojosOrdenService;
    private final AnteojosOrdenMapper anteojosOrdenMapper;

    @PostMapping
    public ResponseEntity<AnteojosOrdenResource> createOrder(@RequestBody CreateAnteojosOrdenResource createAnteojosOrdenResource){
        AnteojosOrden anteojosOrden = anteojosOrdenService.save(anteojosOrdenMapper.toEntity(createAnteojosOrdenResource));
        return ResponseEntity.status(HttpStatus.CREATED).body(anteojosOrdenMapper.toResource(anteojosOrden));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnteojosOrden> getOrderById(@PathVariable Integer id){
        AnteojosOrden anteojosOrden = anteojosOrdenService.findById(Long.valueOf(id));
        return ResponseEntity.ok(anteojosOrden);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnteojosOrden> updateOrder(@PathVariable Integer id, @RequestBody CreateAnteojosOrdenResource createAnteojosOrdenResource){
        AnteojosOrden anteojosOrden = anteojosOrdenService.update(anteojosOrdenMapper.toEntity(createAnteojosOrdenResource));
        return ResponseEntity.ok(anteojosOrden);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id){
        anteojosOrdenService.deleteById(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }


}
