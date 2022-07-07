package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    public ContatoController() {

    }

    //Listar Geral
    @GetMapping
    public List<Contato> list(){
        return contatoService.list();
    }

    //Listar por id pessoa
    @GetMapping("/{idPessoa}")
    public List<Contato> listByIdPessoa(@PathVariable("idPessoa") Integer id){
        return contatoService.listByIdPessoa(id);
    }

    //Adicionar
    @PostMapping("/{idPessoa}")
    public Contato create(@PathVariable("idPessoa") Integer idPessoa, @RequestBody Contato contato) throws Exception{
        return contatoService.create(contato,idPessoa);
    }

    //Atualizar
    @PutMapping("/{idContato}")
    public Contato update(@PathVariable("idContato") Integer id, @RequestBody Contato contatoAtualizar) throws Exception{
        return contatoService.update(id,contatoAtualizar);
    }

    //Deletar
    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws Exception{
        contatoService.delete(id);
    }
}
