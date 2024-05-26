package com.lentecitos.design.design.design.api;

import com.lentecitos.design.design.design.domain.model.entities.PatasAnteojos;
import com.lentecitos.design.design.design.domain.service.PatasAnteojosService;
import com.lentecitos.design.design.design.mapping.PatasAnteojosMapper;
import com.lentecitos.design.design.design.resource.PatasAnteojosResource;
import com.lentecitos.design.design.shared.exception.InternalServerErrorException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/patas_anteojos")
public class PatasAnteojosController {
    private final PatasAnteojosService patasAnteojosService;
    private final PatasAnteojosMapper patasAnteojosMapper;

    @PostMapping
    public ResponseEntity<PatasAnteojosResource> save(@RequestBody PatasAnteojos patasAnteojos){
        return new ResponseEntity<>(
                patasAnteojosMapper.toResource(patasAnteojosService.save(patasAnteojos)),
                org.springframework.http.HttpStatus.CREATED
        );
    }

    @GetMapping ("/{id}")
    public ResponseEntity<PatasAnteojos>  fetchById(@PathVariable("id") Long id){
        return new ResponseEntity<>(
                patasAnteojosService.findById(id),
                org.springframework.http.HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public PatasAnteojos update(@RequestBody PatasAnteojos patasAnteojos, @PathVariable("id") Long id){
        return patasAnteojosService.update(patasAnteojos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        if(patasAnteojosService.deleteById(id))
            return ResponseEntity.ok().build();

        throw new InternalServerErrorException("PatasAnteojos", "id", String.valueOf(id), "deleted");
    }

    @GetMapping
    public ResponseEntity<?> fetchAll(){
        return ResponseEntity.ok(patasAnteojosService.findAll());
    }
}
