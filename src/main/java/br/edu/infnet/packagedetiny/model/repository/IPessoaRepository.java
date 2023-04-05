package br.edu.infnet.packagedetiny.model.repository;

import br.edu.infnet.packagedetiny.model.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface IPessoaRepository extends JpaRepository<Pessoa, Integer> {

    @Query("from Pessoa p where p.funcao = :funcao")
    Collection<Pessoa> findByFuncao(String funcao);
}
