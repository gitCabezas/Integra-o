package com.projetolivro.gerenciador_autores_obras.service;

import com.projetolivro.gerenciador_autores_obras.model.Autor;
import com.projetolivro.gerenciador_autores_obras.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    @Autowired
    public AutorService (AutorRepository autorRepository){
        this.autorRepository= autorRepository;
    }
    public List<Autor> listarTodos(){
        return autorRepository.findAll();
    }
    public Optional<Autor> buscarPorId(Long id){
        return autorRepository.findById(id);
    }
    public Autor salvar (Autor autor){
        return autorRepository.save(autor);
    }
    public void excluir(Long id){
        autorRepository.deleteById(id);
    }

}
