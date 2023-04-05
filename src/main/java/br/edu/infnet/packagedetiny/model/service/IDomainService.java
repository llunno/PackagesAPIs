package br.edu.infnet.packagedetiny.model.service;

import java.util.Collection;


public interface IDomainService<T, ID>{

    T incluir(T t);
    void excluirPorId(ID id);
    void atualizar(T t);
    T findById(ID id);
    Collection<T> findAll();
}
