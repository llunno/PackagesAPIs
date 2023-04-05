package br.edu.infnet.packagedetiny.model.repository;

import br.edu.infnet.packagedetiny.model.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnderecoRepository extends JpaRepository<Endereco, Integer> {
}
