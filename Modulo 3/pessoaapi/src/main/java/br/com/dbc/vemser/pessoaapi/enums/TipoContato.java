package br.com.dbc.vemser.pessoaapi.enums;

public enum TipoContato {
    RESIDENCIAL(1),
    COMERCIAL(2);

    private Integer tipoContato;

    TipoContato(Integer tipoContato){
        this.tipoContato = tipoContato;
    }

    public Integer getTipoContato() {
        return tipoContato;
    }
}
