package br.com.dbc.vemser.pessoaapi.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioPessoaDTO {
    @Schema(description = "Id da pessoa")
    private Integer idPessoa;
    @Schema(description = "Nome pessoa", example = "Bruno")
    private String nome;
    @Schema(description = "email", example = "user@gmail.com")
    private String email;
    @Schema(description = "Numero do contato", example = "5511985734590")
    private String numeroContato;
    @Schema(description = "CEP", example = "05432776")
    private String cep;
    @Schema(description = "Cidade", example = "São Paulo")
    private String cidade;
    @Schema(description = "Estado", example = "SP")
    private String estado;
    @Schema(description = "Pais", example = "Brasil")
    private String pais;
    @Schema(description = "Nome pet", example = "Caramelo")
    private String nomePet;
}
