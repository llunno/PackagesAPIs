package br.edu.infnet.packagedetiny.model.domain;

import com.fasterxml.jackson.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Pacote.class)
public class Pacote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore // ignore this property when serializing
    @OneToMany(mappedBy = "pacote", cascade = CascadeType.ALL)
    private Collection<Item> item;
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<Pessoa> pessoas;
    @Schema(example = "Carga leve e frágil")
    private String descricao;
    @Schema(example = "NR-23: REF-342")
    private String nome;
    @Schema(example = "5")
    private Double peso;
    @Schema(example = "20")
    private Double largura;
    @Schema(example = "10")
    private Double altura;
    @Schema(example = "30")
    private Double comprimento;
}
