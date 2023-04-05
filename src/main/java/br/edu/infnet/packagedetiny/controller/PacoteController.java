package br.edu.infnet.packagedetiny.controller;

import br.edu.infnet.packagedetiny.model.domain.Pacote;
import br.edu.infnet.packagedetiny.model.service.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/pacote")
public class PacoteController implements IController<Pacote, Integer> {

    private final PacoteService pacoteService;

    @Autowired
    public PacoteController(PacoteService pacoteService) {
        this.pacoteService = pacoteService;
    }

    @Override
    public Collection<Pacote> obterTodos() {
        return pacoteService.findAll();
    }

    @Override
    public Pacote obterPorId(Integer id) {
        return pacoteService.findById(id);
    }

    @Override
    public Pacote incluir(Pacote pacote) {
        return pacoteService.incluir(pacote);
    }

    @Override
    public void excluirPorId(Integer id) {
        pacoteService.excluirPorId(id);
    }

    @Override
    public void atualizar(Pacote pacote) {
        pacoteService.atualizar(pacote);
    }

}
