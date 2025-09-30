package com.projetolivro.gerenciador_autores_obras.repository;

import com.projetolivro.gerenciador_autores_obras.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByEmail(String email);
    Optional<Autor> findByCpf(String cpf);
}
