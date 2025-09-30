package com.projetolivro.gerenciador_autores_obras.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Obra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;


    @NotBlank(message = "Descrição é obrigatória")
    @Size(max = 240, message="Descrição deve conter no máximo 240 caracteres")
    private String descricao;

    private LocalDate dataPublicacao;

    private LocalDate dataExposicao;

    @ManyToMany
    @JoinTable (
            name = "autor_obra",
            joinColumns = @JoinColumn(name="obra_id"),
            inverseJoinColumns = @JoinColumn(name="autor_id")
    )
    private Set<Autor> autores= new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Nome é obrigatório") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome é obrigatório") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "Descrição é obrigatória") @Size(max = 240, message = "Descrição deve conter no máximo 240 caracteres") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank(message = "Descrição é obrigatória") @Size(max = 240, message = "Descrição deve conter no máximo 240 caracteres") String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public LocalDate getDataExposicao() {
        return dataExposicao;
    }

    public void setDataExposicao(LocalDate dataExposicao) {
        this.dataExposicao = dataExposicao;
    }
}
