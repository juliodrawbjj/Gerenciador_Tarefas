package com.julio.taskmanager.controller;

import com.julio.taskmanager.entity.Tarefa;
import com.julio.taskmanager.service.TarefaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import jakarta.validation.Valid;

import java.util.List;

@RestController
public class TarefaController {
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService){

        this.tarefaService = tarefaService;
    }

    @GetMapping("/tarefas")
    public List<Tarefa> listarTodas(){

        return tarefaService.listarTodas();
    }

    @PostMapping("/tarefas")
    public Tarefa cadastrar(@Valid @RequestBody Tarefa tarefa){
        return tarefaService.cadastrar(tarefa);
    }

    @GetMapping("/tarefas/{id}")
    public Tarefa buscarPorId(@PathVariable Long id){
        return tarefaService.buscarPorId(id);
    }

    @PutMapping("/tarefas/{id}")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa){
        return tarefaService.atualizar(id, tarefa);
    }

    @DeleteMapping("/tarefas/{id}")
    public void deletar(@PathVariable Long id){
        tarefaService.deletar(id);
    }
}
