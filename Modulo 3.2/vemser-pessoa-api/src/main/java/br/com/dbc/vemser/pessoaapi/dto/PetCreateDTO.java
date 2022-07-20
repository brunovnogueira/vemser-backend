package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.enums.TipoPet;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PetCreateDTO {

    @Schema(description = "Id da pessoa", example = "0")
    private Integer idPessoa;
    @NotBlank
    @Schema(description = "Nome do pet", example = "Bob")
    private String nome;
    @NotNull
    @Schema(description = "Tipo do pet", example = "CACHORRO, GATO, GUAXINIM")
    private TipoPet tipo;

}
