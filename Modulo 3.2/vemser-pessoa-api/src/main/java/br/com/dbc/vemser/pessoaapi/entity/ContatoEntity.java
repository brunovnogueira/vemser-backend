package br.com.dbc.vemser.pessoaapi.entity;

import br.com.dbc.vemser.pessoaapi.enums.TipoContato;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "CONTATO")
public class ContatoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQ")
    @SequenceGenerator(name = "CONTATO_SEQ", sequenceName = "SEQ_CONTATO", allocationSize = 1)
    @Column(name = "ID_CONTATO")
    private Integer idContato;
    @Column(name = "ID_PESSOA", insertable = false, updatable = false)
    private Integer idPessoa;
    @Column(name = "TIPO")
    @Enumerated(EnumType.ORDINAL)
    private TipoContato tipoContato;
    @Column(name = "NUMERO")
    private String numero;
    @Column(name = "DESCRICAO")
    private String descricao;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    private PessoaEntity pessoa;
}
