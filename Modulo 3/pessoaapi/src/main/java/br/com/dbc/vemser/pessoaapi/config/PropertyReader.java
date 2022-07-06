package br.com.dbc.vemser.pessoaapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyReader {
    @Value("${ambiente}")
    private String ambiente;

    public String getAmbiente() {
        return ambiente;
    }
}
