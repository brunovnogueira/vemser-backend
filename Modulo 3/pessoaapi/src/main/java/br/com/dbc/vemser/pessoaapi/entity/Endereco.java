package br.com.dbc.vemser.pessoaapi.entity;

import br.com.dbc.vemser.pessoaapi.enums.TipoEndereco;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    private Integer idPessoa;
    private Integer idEndereco;
    @NotNull
    private TipoEndereco tipo;
    @NotBlank
    @Size(max = 250)
    private String logradouro;
    @NotNull
    private Integer numero;
    private String complemento;
    @NotBlank
    @Size(max = 8)
    private String cep;
    @NotEmpty
    @Size(max = 250)
    private String cidade;
    @NotNull
    private String estado;
    @NotNull
    private String pais;
}
