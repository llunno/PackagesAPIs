package br.edu.infnet.packagedetiny.model.service;

import br.edu.infnet.packagedetiny.model.domain.Item;
import br.edu.infnet.packagedetiny.model.domain.Pacote;
import br.edu.infnet.packagedetiny.model.repository.IPacoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PacoteService implements IDomainService<Pacote, Integer> {

    @Autowired
    private IPacoteRepository pacoteRepository;

    @Override
    public Pacote incluir(Pacote pacote) {
        return pacoteRepository.save(pacote);
    }

    @Override
    public void excluirPorId(Integer id) {
        pacoteRepository.deleteById(id);
    }

    @Override
    public void atualizar(Pacote pacote) {

        Pacote pacoteinDatabase = pacoteRepository.getReferenceById(pacote.getId());
        pacoteinDatabase.setNome(pacote.getNome());
        pacoteinDatabase.setDescricao(pacote.getDescricao());
        pacoteinDatabase.setItem(pacote.getItem());
        pacoteinDatabase.setPeso(pacote.getPeso());
        pacoteinDatabase.setAltura(pacote.getAltura());
        pacoteinDatabase.setLargura(pacote.getLargura());
        pacoteinDatabase.setComprimento(pacote.getComprimento());
        pacoteinDatabase.setPessoas(pacote.getPessoas());
        pacoteRepository.save(pacoteinDatabase);;

    }

    @Override
    public Pacote findById(Integer id) {
        return pacoteRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Pacote> findAll() {
        return pacoteRepository.findAll();
    }
}
