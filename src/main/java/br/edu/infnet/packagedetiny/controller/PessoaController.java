package br.edu.infnet.packagedetiny.controller;

import br.edu.infnet.packagedetiny.model.domain.Pessoa;
import br.edu.infnet.packagedetiny.model.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController implements IController<Pessoa, Integer>{

    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @Override
    public Collection<Pessoa> obterTodos() {
        return pessoaService.findAll();
    }

    @Override
    public Pessoa obterPorId(Integer id) {
        return pessoaService.findById(id);
    }

    @Override
    public Pessoa incluir(Pessoa pessoa) {
        return pessoaService.incluir(pessoa);
    }

    @Override
    public void excluirPorId(Integer id) {
        pessoaService.excluirPorId(id);
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        pessoaService.atualizar(pessoa);
    }
}
