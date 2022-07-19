package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PROFESSOR")
public class ProfessorEntity {
    @EmbeddedId
    private ProfessorPK professorPK;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "SALARIO")
    private Double salario;
}
