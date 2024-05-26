package com.upc.order.design.api;

import com.upc.order.design.domain.model.EstadoOrden;
import com.upc.order.design.domain.service.EstadoOrdenService;
import com.upc.order.design.mapping.EstadoOrdenMapper;
import com.upc.order.design.resource.CreateEstadoOrdenResource;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/estado-orden")
public class EstadoOrdenController {

    private final EstadoOrdenService estadoOrdenService;
    private final EstadoOrdenMapper estadoOrdenMapper;

    @PostMapping
    public ResponseEntity<EstadoOrden> createOrder(@RequestBody CreateEstadoOrdenResource createEstadoOrdenResource){
        EstadoOrden estadoOrden = estadoOrdenService.save(estadoOrdenMapper.toEntity(createEstadoOrdenResource));
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoOrden);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoOrden> getOrderById(@PathVariable Integer id){
        EstadoOrden estadoOrden = estadoOrdenService.findById(Long.valueOf(id));
        return ResponseEntity.ok(estadoOrden);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoOrden> updateOrder(@PathVariable Integer id, @RequestBody CreateEstadoOrdenResource createEstadoOrdenResource){
        EstadoOrden estadoOrden = estadoOrdenService.update(estadoOrdenMapper.toEntity(createEstadoOrdenResource));
        return ResponseEntity.ok(estadoOrden);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id){
        estadoOrdenService.deleteById(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> getAllOrders(){
        return ResponseEntity.ok(estadoOrdenService.findAll());
    }
}
