package com.projetolivro.gerenciador_autores_obras.service;

import com.projetolivro.gerenciador_autores_obras.model.Obra;
import com.projetolivro.gerenciador_autores_obras.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObraService {
    private final ObraRepository obraRepository;

    @Autowired
    public ObraService(ObraRepository obraRepository){
      this.obraRepository=obraRepository;
        }
    public List<Obra> listarTodas(){
        return obraRepository.findAll();
    }
    public Optional<Obra> buscarPorId(Long id){
        return obraRepository.findById(id);
    }
    public Obra salvar (Obra obra){
        return obraRepository.save(obra);
    }
    public void excluir(Long id){
        obraRepository.deleteById(id);
    }
}
