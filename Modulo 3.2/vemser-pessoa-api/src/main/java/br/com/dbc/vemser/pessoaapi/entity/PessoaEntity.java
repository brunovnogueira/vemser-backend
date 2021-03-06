package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PESSOA")
public class PessoaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
    @SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "seq_pessoa2", allocationSize = 1)
    @Column(name = "ID_PESSOA")
    private Integer idPessoa;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ID_PET", insertable = false, updatable = false)
    private String idPet;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "pessoa",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<ContatoEntity> contatos;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Pessoa_X_Pessoa_Endereco",
            joinColumns = @JoinColumn(name = "id_pessoa"),
            inverseJoinColumns = @JoinColumn(name = "id_endereco"))
    private Set<EnderecoEntity> enderecos;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_pet", referencedColumnName = "id_pet")
    private PetEntity pet;
}
