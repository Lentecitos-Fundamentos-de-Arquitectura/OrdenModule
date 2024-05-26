package com.upc.order.design.api;

import com.upc.order.design.domain.model.Orden;
import com.upc.order.design.domain.service.OrdenService;
import com.upc.order.design.mapping.OrdenMapper;
import com.upc.order.design.resource.CreateOrdenResource;
import com.upc.order.design.resource.OrdenResource;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrdenController {

    private final OrdenService ordenService;
    private final OrdenMapper ordenMapper;

    @PostMapping
    public ResponseEntity<OrdenResource> createOrder(@RequestBody CreateOrdenResource createOrdenResource){
        Orden orden = ordenService.save(ordenMapper.toEntity(createOrdenResource));
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenMapper.toResource(orden));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenResource> getOrderById(@PathVariable Integer id){
        Orden orden = ordenService.findById(Long.valueOf(id));
        return ResponseEntity.ok(ordenMapper.toResource(orden));
    }

    @GetMapping
    public ResponseEntity<List<OrdenResource>> getAllOrders(){
        List<Orden> ordenes = ordenService.findAll();
        return ResponseEntity.ok(ordenes.stream().map(ordenMapper::toResource).collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenResource> updateOrder(@PathVariable Integer id, @RequestBody CreateOrdenResource createOrdenResource){
        Orden orden = ordenService.update(ordenMapper.toEntity(createOrdenResource));
        return ResponseEntity.ok(ordenMapper.toResource(orden));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id){
        ordenService.deleteById(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }

}
