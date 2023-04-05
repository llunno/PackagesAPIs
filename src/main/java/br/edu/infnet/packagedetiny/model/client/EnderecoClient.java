package br.edu.infnet.packagedetiny.model.client;

import br.edu.infnet.packagedetiny.model.domain.Endereco;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EnderecoClient {
    private final String url = "https://viacep.com.br/ws/";

    WebClient webClient = WebClient.create(url);

    public Endereco getEndereco(String cep) {
        return webClient.get()
                .uri(cep + "/json")
                .retrieve()
                .bodyToMono(Endereco.class)
                .block();
    }
}
