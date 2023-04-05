package br.edu.infnet.packagedetiny.model.service;

import br.edu.infnet.packagedetiny.model.client.EnderecoClient;
import br.edu.infnet.packagedetiny.model.domain.Endereco;
import br.edu.infnet.packagedetiny.model.domain.Pessoa;
import br.edu.infnet.packagedetiny.model.repository.IEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EnderecoService implements IDomainService<Endereco, Integer> {


    private final IEnderecoRepository enderecoRepository;
    private final EnderecoClient enderecoClient;

    @Autowired
    public EnderecoService(IEnderecoRepository enderecoRepository, EnderecoClient enderecoClient) {
        this.enderecoRepository = enderecoRepository;
        this.enderecoClient = enderecoClient;
    }

    @Override
    public Endereco incluir(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public void excluirPorId(Integer integer) {
         enderecoRepository.deleteById(integer);
    }

    @Override
    public void atualizar(Endereco endereco) {
        Endereco enderecoInDatabase = enderecoRepository.getReferenceById(endereco.getId());
        enderecoInDatabase.setCep(endereco.getCep());
        enderecoInDatabase.setLogradouro(endereco.getLogradouro());
        enderecoInDatabase.setComplemento(endereco.getComplemento());
        enderecoInDatabase.setBairro(endereco.getBairro());
        enderecoInDatabase.setLocalidade(endereco.getLocalidade());
        enderecoInDatabase.setUf(endereco.getUf());
        enderecoInDatabase.setPessoa(endereco.getPessoa());
        enderecoRepository.save(endereco);;;
    }

    @Override
    public Endereco findById(Integer id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Endereco acharPorCep(String cep) {

        if (enderecoClient.getEndereco(cep) != null)
            return enderecoClient.getEndereco(cep);
        else {
            return null;
        }

    }
}
