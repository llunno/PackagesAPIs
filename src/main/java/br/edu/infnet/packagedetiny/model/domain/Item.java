package br.edu.infnet.packagedetiny.model.domain;

import com.fasterxml.jackson.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Item.class)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Schema(example = "Hard Disk")
    private String nome;
    @Schema(example = "Eletrônico")
    private String tipo;
    @Schema(example = "Hd para utilização em notebooks pequenos, 2.5")
    private String descricao;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Pacote pacote;
}
