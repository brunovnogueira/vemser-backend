package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.enums.TipoContato;
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
public class ContatoDTOCreate {
    @Schema(description = "Id da pessoa")
    private Integer idPessoa;
    @Schema(description = "Tipo do contato")
    @NotNull
    private TipoContato tipoContato;
    @Schema(description = "Número do telefone/celular")
    @NotBlank
    @Size(max = 13)
    private String numero;
    @Schema(description = "Descrição do contato")
    @NotEmpty
    private String descricao;
}
