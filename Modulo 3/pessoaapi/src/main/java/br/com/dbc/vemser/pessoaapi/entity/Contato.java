package br.com.dbc.vemser.pessoaapi.entity;

import br.com.dbc.vemser.pessoaapi.enums.TipoContato;
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
public class Contato {
    private Integer idContato;
    private Integer idPessoa;
    //TODO: Criar enum para o tipo
    @NotNull
    private TipoContato tipoContato;
    @NotBlank
    @Size(max = 13)
    private String numero;
    @NotEmpty
    private String descricao;
}
