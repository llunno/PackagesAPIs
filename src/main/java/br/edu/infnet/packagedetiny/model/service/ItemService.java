package br.edu.infnet.packagedetiny.model.service;

import br.edu.infnet.packagedetiny.model.domain.Item;
import br.edu.infnet.packagedetiny.model.repository.IItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ItemService implements IDomainService<Item, Integer> {
    private final IItemRepository itemRepository;

    @Autowired
    public ItemService(IItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item incluir(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void excluirPorId(Integer id) {
        itemRepository.deleteById(id);
    }

    @Override
    public void atualizar(Item item) {
        Item iteminDatabase = itemRepository.getReferenceById(item.getId());
        iteminDatabase.setNome(item.getNome());
        iteminDatabase.setTipo(item.getTipo());
        iteminDatabase.setDescricao(item.getDescricao());
        iteminDatabase.setPacote(item.getPacote());
        itemRepository.save(iteminDatabase);
    }

    @Override
    public Item findById(Integer id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findByNome(String nome) {
        return itemRepository.findBynome(nome);
    }
}
