package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;

import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paginacao")
public class PaginacaoController {
    @Autowired
    ContatoRepository contatoRepository;
    @Autowired
    EnderecoRepository enderecoRepository;

    @GetMapping("/contato-por-descricao")
    public Page<ContatoEntity> listContato(Integer pagina, Integer registros){
        Pageable pageable = PageRequest.of(pagina, registros,Sort.by("descricao"));
        return contatoRepository.listPaginacao(pageable);
    }

    @GetMapping("/endereco-por-cep")
    public Page<EnderecoEntity> listEndereco(Integer pagina, Integer registros){
        Pageable pageable = PageRequest.of(pagina, registros, Sort.by("cep"));
        return enderecoRepository.listByCepPage(pageable);
    }

    @GetMapping("/endereco-por-pais")
    public Page<EnderecoEntity> listEnderecoPais(Integer pagina, Integer registros, String pais){
        Pageable pageable = PageRequest.of(pagina, registros, Sort.by("cep"));
        return enderecoRepository.listByPaisPage(pageable,pais);
    }
}
