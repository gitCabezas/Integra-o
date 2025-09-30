package com.projetolivro.gerenciador_autores_obras.controller;


import com.projetolivro.gerenciador_autores_obras.model.Autor;
import com.projetolivro.gerenciador_autores_obras.model.Obra;
import com.projetolivro.gerenciador_autores_obras.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.ClassUtils.isPresent;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    private final AutorService autorService;

    @Autowired
    public AutorController(AutorService autorService){
        this.autorService= autorService;
    }

    @GetMapping
    public List<Autor> listarTodos(){
        return autorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarPorId(@PathVariable Long id){
        Optional<Autor> autor=autorService.buscarPorId(id);
        return autor.map(ResponseEntity::ok).orElseGet(() ->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Autor> criar (@RequestBody Autor autor){
        Autor novoAutor = autorService.salvar(autor);
        return new ResponseEntity<>(novoAutor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> atualizar(@PathVariable Long id, @RequestBody Autor autor) {
        if (!autorService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        autor.setId(id);
        Autor autorAtualizado = autorService.salvar(autor);
        return ResponseEntity.ok(autorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> exluir (@PathVariable Long id){
        if (!autorService.buscarPorId(id).isPresent()){
        return ResponseEntity.notFound().build();
        }
        autorService.excluir(id);
        return ResponseEntity.noContent().build();
    }


}
