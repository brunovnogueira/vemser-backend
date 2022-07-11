package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pessoa {

    private Integer idPessoa;
    @NotBlank //valida se não é nula e nem com espaços em branco
    private String nome;
    @NotNull(message = "Informe a data de nascimento")
    private LocalDate dataNascimento;
    @CPF(message = "CPF inválido")
    private String cpf;
    private String email;

}
