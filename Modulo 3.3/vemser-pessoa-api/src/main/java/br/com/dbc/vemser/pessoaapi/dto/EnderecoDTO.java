package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EnderecoDTO extends EnderecoDTOCreate {
    @Schema(description = "Id do endereço")
    private Integer idEndereco;
}
