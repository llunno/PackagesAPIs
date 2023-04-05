package br.edu.infnet.packagedetiny.model.repository;

import br.edu.infnet.packagedetiny.model.domain.Pacote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacoteRepository extends JpaRepository<Pacote, Integer> {
}
