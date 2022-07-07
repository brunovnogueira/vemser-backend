package br.com.dbc.vemser.pessoaapi.enums;

import java.util.Arrays;

public enum TipoEndereco {
    RESIDENCIAL(1),
    COMERCIAL(2);

    private Integer tipoEndereco;

    TipoEndereco(Integer tipoEndereco){
        this.tipoEndereco = tipoEndereco;
    }

    public static TipoEndereco ofTipo (Integer tipoEndereco){
        return Arrays.stream(TipoEndereco.values()).filter(tipoEndereco1 -> tipoEndereco1.getTipoEndereco().equals(tipoEndereco))
                .findFirst()
                .get();
    }

    public Integer getTipoEndereco() {
        return tipoEndereco;
    }
}
