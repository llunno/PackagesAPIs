package br.edu.infnet.packagedetiny.controller;

import br.edu.infnet.packagedetiny.model.domain.Item;
import br.edu.infnet.packagedetiny.model.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/item")
public class ItemController implements IController<Item, Integer> {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public Collection<Item> obterTodos() {
        return itemService.findAll();
    }

    @Override
    public Item obterPorId(Integer id) {
        return itemService.findById(id);
    }

    @Override
    public Item incluir(Item item) {
        return itemService.incluir(item);
    }

    @Override
    public void excluirPorId(Integer id) {
        itemService.excluirPorId(id);
    }

    @Override
    public void atualizar(Item item) {
        itemService.atualizar(item);
    }
}
