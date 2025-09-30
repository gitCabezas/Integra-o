package com.projetolivro.gerenciador_autores_obras.controller;


import com.projetolivro.gerenciador_autores_obras.model.Obra;
import com.projetolivro.gerenciador_autores_obras.service.ObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/obras")
public class ObraController {
    private final ObraService obraService;

    @Autowired
    public ObraController (ObraService obraService){
        this.obraService=obraService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Obra> buscarPorId(@PathVariable Long id){
        Optional<Obra> obra= obraService.buscarPorId(id);
        return obra.map(ResponseEntity::ok).orElseGet(() -> (ResponseEntity<Obra>) ResponseEntity.notFound());
    }

    @PostMapping
    public ResponseEntity<Obra> criar (@RequestBody Obra obra){
        Obra novaObra= obraService.salvar(obra);
        return new ResponseEntity<>(novaObra, HttpStatus.CREATED);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Obra> atualizar (@PathVariable Long id, @RequestBody Obra obra){
        if (!obraService.buscarPorId(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        obra.setId(id);
        Obra obraAtualizada = obraService.salvar(obra);
        return ResponseEntity.ok(obraAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir (@PathVariable Long id){
        if (!obraService.buscarPorId(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        obraService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
