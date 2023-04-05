package br.edu.infnet.packagedetiny.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/default")
public interface IController<T,ID> {

    @GetMapping("/consulta/all")
    Collection<T> obterTodos();

    @GetMapping("/consulta/{id}" )
    T obterPorId(@PathVariable ID id);

    @PostMapping("/incluir")
    T incluir(@RequestBody T t);

    @DeleteMapping("/excluir/{id}" )
    void excluirPorId(@PathVariable ID id);

    @PutMapping("/atualizar")
    void atualizar(@RequestBody T t);
}
