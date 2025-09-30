package com.projetolivro.gerenciador_autores_obras.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    private  String sexo;

    @Email(message = "E-mail deve ser válido")
    @Column(unique = true)
    private String email;

    @NotNull(message = "Data de nascimento é obrigatória")
    private LocalDate dataNascimento;

    @NotBlank(message="País de Origem é obrigatório")
    private String paisOrigem;

    @Column(unique = true)
    private String cpf;

    @ManyToMany(mappedBy= "autores")
    private Set<Obra> obras= new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank(message = "Nome é obrigatório") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome é obrigatório") String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public @Email(message = "E-mail deve ser válido") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "E-mail deve ser válido") String email) {
        this.email = email;
    }

    public @NotNull(message = "Data de nascimento é obrigatória") LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(@NotNull(message = "Data de nascimento é obrigatória") LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotBlank(message = "País de Origem é obrigatório") String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(@NotBlank(message = "País de Origem é obrigatório") String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
