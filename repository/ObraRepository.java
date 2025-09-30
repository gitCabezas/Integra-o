package com.projetolivro.gerenciador_autores_obras.repository;

import com.projetolivro.gerenciador_autores_obras.model.Obra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraRepository extends JpaRepository<Obra, Long> {

}
