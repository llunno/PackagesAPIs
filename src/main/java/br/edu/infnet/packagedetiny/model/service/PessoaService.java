package br.edu.infnet.packagedetiny.model.service;

import br.edu.infnet.packagedetiny.model.domain.Endereco;
import br.edu.infnet.packagedetiny.model.domain.Pacote;
import br.edu.infnet.packagedetiny.model.domain.Pessoa;
import br.edu.infnet.packagedetiny.model.repository.IPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PessoaService implements IDomainService<Pessoa, Integer> {

    private final IPessoaRepository pessoaRepository;
    private final PacoteService pacoteService;
    private final EnderecoService enderecoService;

    @Autowired
    public PessoaService(IPessoaRepository pessoaRepository, PacoteService pacoteService, EnderecoService enderecoService) {
        this.pessoaRepository = pessoaRepository;
        this.pacoteService = pacoteService;
        this.enderecoService = enderecoService;
    }

    @Override
    public Pessoa incluir(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public void excluirPorId(Integer id) {
        pessoaRepository.deleteById(id);
    }

    @Override
    public void atualizar(Pessoa pessoa) {

        Pessoa pessoaInDatabase = pessoaRepository.getReferenceById(pessoa.getId());
        pessoaInDatabase.setNome(pessoa.getNome());
        pessoaInDatabase.setFuncao(pessoa.getFuncao());
        pessoaInDatabase.setCpf(pessoa.getCpf());
        pessoaInDatabase.setTelefone(pessoa.getTelefone());
        pessoaInDatabase.setEnderecos(pessoa.getEnderecos());
        pessoaInDatabase.setEmail(pessoa.getEmail());
        pessoaInDatabase.setSenha(pessoa.getSenha());;
        pessoaInDatabase.setPacotes(pessoa.getPacotes());
        pessoaRepository.save(pessoaInDatabase);;

    }

    @Override
    public Pessoa findById(Integer id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Collection<Pessoa> findByFuncao(String funcao) {
        return pessoaRepository.findByFuncao(funcao);
    }
}
