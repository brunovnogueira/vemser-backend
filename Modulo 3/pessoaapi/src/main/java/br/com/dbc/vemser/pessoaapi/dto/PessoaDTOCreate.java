package br.com.dbc.vemser.pessoaapi.dto;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PessoaDTOCreate {
    @NotBlank
    private String nome;
    @NotNull
    private LocalDate dataNascimento;
    @CPF
    @NotBlank
    private String cpf;
    @Email
    @NotBlank
    private String email;
}
