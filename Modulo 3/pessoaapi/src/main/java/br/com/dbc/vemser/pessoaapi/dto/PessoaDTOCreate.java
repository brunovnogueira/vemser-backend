package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "Nome da Pessoa")
    @NotBlank
    private String nome;
    @Schema(description = "Data de nascimento")
    @NotNull
    private LocalDate dataNascimento;
    @Schema(description = "CPF da pessoa")
    @CPF
    @NotBlank
    private String cpf;
    @Schema(description = "Email da pessoa")
    @Email
    @NotBlank
    private String email;
}
