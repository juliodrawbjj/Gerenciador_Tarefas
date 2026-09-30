package com.julio.taskmanager.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Preencher o titulo é obrigatório!")
    private  String titulo;
    private  String descricao;
    @NotNull(message = "A data de entrega final  deve ser preenchida")
    private LocalDate dataEntrega;
    @Enumerated(EnumType.STRING)
    private StatusTarefa status;

    public Tarefa() {
    }

    public Tarefa(String titulo, String descricao,
                  LocalDate dataEntrega, StatusTarefa status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
        this.status  = status;
    }

    public Long getId(){

        return id;
    }

    public String getTitulo(){

        return titulo;
    }

    public void setTitulo(String titulo){

        this.titulo = titulo;
    }

    public String getDescricao(){

        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public LocalDate getDataEntrega(){

        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega){

        this.dataEntrega = dataEntrega;
    }

    public StatusTarefa getStatus(){

        return status;
    }

    public void setStatus(StatusTarefa status){

        this.status = status;
    }



}
