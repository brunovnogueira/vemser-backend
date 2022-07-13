package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.enums.TipoEndereco;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EnderecoDTOCreate {
    @Schema(description = "Id da pessoa")
    private Integer idPessoa;
    @Schema(description = "Tipo do endereço")
    @NotNull
    private TipoEndereco tipo;
    @Schema(description = "Logradouro do endereço")
    @NotBlank
    @Size(max = 250)
    private String logradouro;
    @Schema(description = "Número do endereço")
    @NotNull
    private Integer numero;
    @Schema(description = "Complemento do endereço")
    private String complemento;
    @Schema(description = "CEP do endereço")
    @NotBlank
    @Size(max = 8)
    private String cep;
    @Schema(description = "Cidade do endereço")
    @NotEmpty
    @Size(max = 250)
    private String cidade;
    @Schema(description = "Estado do endereço")
    @NotNull
    private String estado;
    @Schema(description = "País do endereço")
    @NotNull
    private String pais;
}
