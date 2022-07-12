package br.com.dbc.vemser.pessoaapi.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ContatoDTO extends ContatoDTOCreate {
    private Integer idContato;
}
