package br.com.dbc.vemser.pessoaapi.enums;

import java.util.Arrays;

public enum TipoEndereco {
    RESIDENCIAL(1),
    COMERCIAL(2);

    private Integer tipoEndereco;

    TipoEndereco(Integer tipoEndereco){
        this.tipoEndereco = tipoEndereco;
    }
    

    public Integer getTipoEndereco() {
        return tipoEndereco;
    }
}
