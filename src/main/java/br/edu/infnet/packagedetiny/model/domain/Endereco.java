package br.edu.infnet.packagedetiny.model.domain;

import com.fasterxml.jackson.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Endereco.class)
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Schema(example = "02045040")
    private String cep;
    @Schema(example = "Avenida Pedro Américo")
    private String logradouro;
    @Schema(example = "Casa 234")
    private String complemento;
    @Schema(example = "Capoeirão")
    private String bairro;
    @Schema(example = "São Paulo")
    private String localidade;
    @Schema(example = "SP")
    private String uf;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH)
    private Pessoa pessoa;

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }

}
