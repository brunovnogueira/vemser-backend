package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    private ContatoService contatoService;

    public ContatoController() {
        contatoService = new ContatoService();
    }

    //Listar Geral
    @GetMapping
    public List<Contato> list(){
        return contatoService.list();
    }

    //Listar por id pessoa
    @GetMapping("/byidpessoa")
    public List<Contato> listByIdPessoa(@RequestParam("idPessoa") Integer id){
        return contatoService.listByIdPessoa(id);
    }

    //Adicionar
    @PostMapping
    public Contato create(@RequestBody Contato contato) throws Exception{
        return contatoService.create(contato);
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
