package br.edu.infnet.packagedetiny.model.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Pessoa.class)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Schema(example = "Carlos Renato")
    private String nome;
    @Schema(example = "Carlosrer@example.com")
    private String email;
    @Schema(example = "carlin@ii21")
    private String senha;
    @Schema(example = "(25) 99345-3299")
    private String telefone;
    @Schema(example = "456.754.345-67")
    private String cpf;
    @Schema(example = "Remetente")
    private String funcao;
    @JsonProperty
    @OneToMany(mappedBy = "pessoa",cascade = CascadeType.ALL)
    private Collection<Endereco> enderecos;
    @JsonProperty
    @ManyToMany(mappedBy = "pessoas",cascade = CascadeType.ALL)
    private Collection<Pacote> pacotes;

    public Pessoa(String nome, String email, String senha, Collection<Endereco> enderecos, String telefone, String cpf, Collection<Pacote> pacote, String funcao) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.enderecos = enderecos;
        this.telefone = telefone;
        this.cpf = cpf;
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", endereco=" + enderecos.size() +
                ", telefone='" + telefone + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
