package com.julio.taskmanager.exception;

import com.julio.taskmanager.dto.ErroResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

//"Essa classe vai observar e tratar exceções que acontecem nos meus Controllers."
@RestControllerAdvice
public class GlobalExceptionHandler {

    //"Quando acontecer uma exceção desse tipo, use o método que vem logo abaixo para tratá-la."
    @ExceptionHandler(TarefaNaoEncontradaException.class)//"Quando acontecer uma TarefaNaoEncontradaException, use este método para tratá-la."
    public ResponseEntity<ErroResponse> tratarTarefaNaoEncontrada(TarefaNaoEncontradaException exception){

        List<String> mensagens = new ArrayList<>();
        mensagens.add(exception.getMessage());

        ErroResponse erro = new ErroResponse(404, mensagens);
        return ResponseEntity.status(404).body(erro);




    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> tratarErroDeValidacao(MethodArgumentNotValidException exception) {

            List<FieldError> erros = exception.getBindingResult()
                .getFieldErrors();

            List<String> mensagens = new ArrayList<>();

            for (FieldError erro: erros){
                String mensagem = erro.getDefaultMessage();
                String campo = erro.getField();


                String mensagemPersonalizada = "Campo " + campo + " : " + mensagem;

                mensagens.add(mensagemPersonalizada);
            }

            ErroResponse erroResponse = new ErroResponse(400, mensagens);

            return ResponseEntity.status(400).body(erroResponse);

    }
}
