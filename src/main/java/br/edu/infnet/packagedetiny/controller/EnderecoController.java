package br.edu.infnet.packagedetiny.controller;

import br.edu.infnet.packagedetiny.model.domain.Endereco;
import br.edu.infnet.packagedetiny.model.service.EnderecoService;
import br.edu.infnet.packagedetiny.utils.StringToJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @Autowired
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping("/all")
    public String getEnderecos() {

        Gson gson = new Gson();

        return gson.toJson(enderecoService.findAll());
    }

    @GetMapping("/cep/{cep}")
    public String getEndereco(@PathVariable String cep) {

        Endereco endereco;
        try {
            endereco = enderecoService.acharPorCep(cep);
        } catch (Exception e) {
            return "Erro ao buscar endereço: " + e.getMessage();
        }

        Gson gson = new Gson();

        return gson.toJson(endereco);
    }

    @PostMapping("/salvar")
    public Endereco incluirEndereco(@RequestBody Endereco endereco) {
        Gson gson = new Gson();
        return enderecoService.incluir(endereco);
    }

    @DeleteMapping("/excluir/{id}")
    public String excluirEndereco(@PathVariable Integer id) {

        try {
            enderecoService.excluirPorId(id);
            return StringToJson.toJson("Mensagem", "Endereço excluído com sucesso!");
        } catch (Exception e) {
            return StringToJson.toJson("Mensagem", "Erro ao tentar excluir!");
        }
    }

    @GetMapping("/id/{id}")
    public Endereco getById(@PathVariable Integer id) {

        return enderecoService.findById(id);
    }


    @PutMapping("/atualizar")
    public String atualizarEndereco(@RequestBody Endereco endereco) {

        if (enderecoService.findById(endereco.getId()) == null) {
            return StringToJson.toJson("Mensagem", "Erro ao atualizar endereço: O endereço não existe");
        }
        else {
            try {
                enderecoService.atualizar(endereco);
                return StringToJson.toJson("Mensagem", "Endereço atualizado com sucesso!");
            } catch (Exception e) {
                return StringToJson.toJson("Mensagem", "Erro ao atualizar endereço");
            }
        }
    }
}
