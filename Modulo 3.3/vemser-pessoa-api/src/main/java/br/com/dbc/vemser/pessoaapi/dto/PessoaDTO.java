package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PessoaDTO extends PessoaDTOCreate {
    @Schema(description = "Id da pessoa")
    private Integer idPessoa;
    @Schema(description = "Lista de endereços")
    private List<ContatoDTO> contatos;
    @Schema(description = "Lista de endereços")
    private List<EnderecoDTO> enderecos;
    @Schema(description = "Lista de pets")
    private PetDTO pets;
}
