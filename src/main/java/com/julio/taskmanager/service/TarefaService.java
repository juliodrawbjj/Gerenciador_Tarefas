package com.julio.taskmanager.service;

import com.julio.taskmanager.entity.Tarefa;
import com.julio.taskmanager.exception.TarefaNaoEncontradaException;
import com.julio.taskmanager.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    //CONSTRUCTOR
    public TarefaService(TarefaRepository tarefaRepository){
        this.tarefaRepository = tarefaRepository;
    }

    //Esse metodo pede pro tarefaRepository ir lá no banco e listar todas as tarefas que tem lá.
    public List<Tarefa> listarTodas(){

        return tarefaRepository.findAll();//listar todas
    }

    public Tarefa cadastrar(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    public Tarefa buscarPorId(Long id){
        return tarefaRepository.findById(id)
                //Se encontrou a tarefa:
                //    devolva a tarefa
                //
                //Se NÃO encontrou:
                //    execute essa função → crie TarefaNaoEncontradaException
                .orElseThrow(() -> new TarefaNaoEncontradaException(
                        "Tarefa " + id + " não encontrada"
                ));//caso não tenha atividade, abre uma exceção
    }

    public Tarefa atualizar(Long id, Tarefa tarefa){
        Optional<Tarefa> tarefaExistente = tarefaRepository.findById(id);

        Tarefa tarefaAtual = tarefaExistente.orElseThrow(() -> new TarefaNaoEncontradaException(
                "Tarefa não encontrada" + id
        ));

        tarefaAtual.setTitulo(tarefa.getTitulo());
        tarefaAtual.setDescricao(tarefa.getDescricao());
        tarefaAtual.setDataEntrega(tarefa.getDataEntrega());
        tarefaAtual.setStatus(tarefa.getStatus());

        return tarefaRepository.save(tarefaAtual);
    }

    public void deletar(Long id){
       tarefaRepository.deleteById(id);
    }

}
