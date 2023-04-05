package br.edu.infnet.packagedetiny.model.repository;

import br.edu.infnet.packagedetiny.model.domain.Item;
import br.edu.infnet.packagedetiny.model.domain.Pessoa;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface IItemRepository extends JpaRepository<Item, Integer> {

    @Query("from Item i where i.nome = :nome")
    Item findBynome(String nome);
}
