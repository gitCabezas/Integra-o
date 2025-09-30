package com.projetolivro.gerenciador_autores_obras;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.projetolivro.gerenciador_autores_obras.model.Autor;
import com.projetolivro.gerenciador_autores_obras.repository.AutorRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@DataJpaTest
public class AutorServiceTest {

    @Autowired
    private AutorRepository autorRepository;

    private Autor autor1, autor2;

    @BeforeEach
    public void setup(){
        autor1 = new Autor();
        autor1.setNome("Autor 1");
        autor1.setCpf("123.456.789-02");
        autor1.setEmail("autor1@autor.com");
        autor1.setPaisOrigem("Brasil");
        autor1.setSexo("Masculino");
        autor1.setDataNascimento(LocalDate.of(1990,01,01));

        autor2 = new Autor();
        autor2.setNome("Autor 2");
        autor2.setCpf("123.456.789-02");  // CPF duplicado
        autor2.setEmail("autor1@autor.com");  // E-mail duplicado
        autor2.setPaisOrigem("Canada");
        autor2.setSexo("Feminino");
        autor2.setDataNascimento(LocalDate.of(1990,02,02));

    }

    @Test
    public void deveImpedirAutoresComCpfOuEmailDuplicados(){
        autorRepository.save(autor1);  // Salva o primeiro autor

        // Verifica se a tentativa de salvar autor2 com CPF e e-mail duplicados gera exceção de violação de restrição
        assertThrows(DataIntegrityViolationException.class, () -> {
            autorRepository.save(autor2);
        });
    }
}
